package com.o2o.pn.web.wechat;


import com.o2o.pn.dto.UserAccessToken;
import com.o2o.pn.dto.WechatAuthExecution;
import com.o2o.pn.dto.WechatUser;
import com.o2o.pn.entity.PersonInfo;
import com.o2o.pn.entity.WechatAuth;
import com.o2o.pn.enums.WechatAuthStateEnum;
import com.o2o.pn.service.PersonInfoService;
import com.o2o.pn.service.WechatAuthService;
import com.o2o.pn.util.wechat.WechatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取关注公众号之后的微信用户信息的接口，如果在微信浏览器里访问
 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx62f2cfb547db16d6&redirect_uri=http://47.104.199.43/wechatlogin/logincheck&role_type=1&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect
 * 则这里将会获取到code,之后再可以通过code获取到access_token 进而获取到用户信息
 *
 * @author xiangze
 *
 */
@Controller
@RequestMapping("/wechatlogin")
public class WechatLoginContreller {

    private Logger log = LoggerFactory.getLogger(WechatLoginContreller.class);
    private static final String FRONTEND= "1";
    private static final String SHOP="2";
    @Autowired
    private PersonInfoService personInfoService;
    @Autowired
    private WechatAuthService wechatAuthService;
    @RequestMapping(value = "/logincheck",method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, HttpServletResponse response){
        log.debug("微信登陆中.....");
        //获取微信公众号传输过来的code 通过code可获取access_token进而获取用户信息
    String code = request.getParameter("code");
    //这个state可以用来穿我们自定义的信息，方便程旭调用，这里也可以不用
        String roleType = request.getParameter("state");
        log.debug("weixin login code:"+code );
        WechatUser user = null;
        String openId = null;
        WechatAuth auth = null;
        if(null !=code){
            UserAccessToken token;
            try {
                //通过code获取access_token
                token = WechatUtil.getUserAccessToken(code);
                log.debug("weixin login token:"+token.toString());
                //通过token 获取accessToken
                String accessToken = token.getAccessToken();
                //通过TOKEN获取用户openId
                openId = token.getOpenId();
                //通过accesss_tokenh和openId获取用户昵称等信息
                user = WechatUtil.getUserInfo(accessToken,openId);
                log.debug("weixin login user:" +user.toString());
                request.getSession().setAttribute("openId",openId);
                auth = wechatAuthService.getWechatAuthByOpenId(openId);
            }catch (IOException e){
                log.error("error in getUserAccessToken or getUserInfo or findByOpenId:"+e.toString());
                e.printStackTrace();
            }
        }


        //前面获取到openId后，可以通过他去数据库判断该微信账号是否在我们网站里有对应账号了，
        //没有的话这里可以自动创建上，直接实现微信与网站的无缝对接、
        if (auth ==null){
            PersonInfo personInfo = WechatUtil.getPersonInfoFromRequest(user);
            auth = new WechatAuth();
            auth.setOpenId(openId);
            if (FRONTEND.equals(roleType)){
                personInfo.setUserType(1);
            }else {
                 personInfo.setUserType(2);
            }
            auth.setPersonInfo(personInfo);
            WechatAuthExecution we = wechatAuthService.register(auth);
            if (we.getState() !=WechatAuthStateEnum.SUCCESS.getState()){
                return null;
            }else {
                personInfo = personInfoService.getPersonInfoById(auth.getPersonInfo().getUserId());
                request.getSession().setAttribute("user",personInfo);
            }
        }
        //若用户点击的是前端展示系统页则进入前端展示系统
        if (FRONTEND.equals(roleType)){
        return  "frontend/index";
        }else {
        return "shop/shoplist";
        }
    }
}
