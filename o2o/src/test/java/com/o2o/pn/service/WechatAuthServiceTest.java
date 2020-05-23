//package com.o2o.pn.service;
//
//import com.o2o.pn.BaseTest;
//import com.o2o.pn.dto.WechatAuthExecution;
//import com.o2o.pn.entity.PersonInfo;
//import com.o2o.pn.entity.WechatAuth;
//import com.o2o.pn.enums.WechatAuthStateEnum;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//
//import static org.junit.Assert.assertEquals;
//
//public class WechatAuthServiceTest extends BaseTest {
//    @Autowired
//    private WechatAuthService wechatAuthService;
//    @Test
//    public void testARegister(){
//
//
//        //新增一条微信账号
//        WechatAuth wechatAuth = new WechatAuth();
//        PersonInfo personInfo = new PersonInfo();
//        String openId = "sdaffewrcvzxcv";
//        //给微信账号设置用户信息，单不设置上用户Id
//        //希望穿件微信账号的时候自动创建用户信息
//        personInfo.setCreateTime(new Date());
//        personInfo.setName("测试");
//        personInfo.setUserType(1);
//        wechatAuth.setPersonInfo(personInfo);
//        wechatAuth.setOpenId(openId);
//        wechatAuth.setCreateTime(new Date());
//        WechatAuthExecution wae = wechatAuthService.register(wechatAuth);
//        assertEquals(WechatAuthStateEnum.SUCCESS.getState(),wae.getState());
//        //通过openId找到新增的WeChatAuth
//        wechatAuth = wechatAuthService.getWechatAuthByOpenId(openId);
//        //打印用户名字看看和预期是否相符
//        System.out.println(wechatAuth.getPersonInfo().getName());
//    }
//}
