package com.o2o.pn.web.wechat;


import com.o2o.pn.util.wechat.SignUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Controller
@RequestMapping("/wechat")
public class WechatController {

    @RequestMapping(method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        log.println("weixin get....");
        String signature =request.getParameter("signature");
        String timestamp =request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        //通过检验signature对请求进行校验，若成功校验这以昂扬返回echostr ,表示接入成功，否则接入失败
        PrintWriter out =null;
        try {
            out = response.getWriter();
            if (SignUtil.checkSignature(signature,timestamp,nonce)){
                log.println("weixin get success");
                out.print(echostr);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (out !=null){
                out.close();
            }
        }


    }
}
