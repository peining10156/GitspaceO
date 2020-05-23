//package com.o2o.pn.service;
//
//import com.o2o.pn.BaseTest;
//import com.o2o.pn.dto.LocalAuthExecution;
//import com.o2o.pn.entity.LocalAuth;
//import com.o2o.pn.entity.PersonInfo;
//import com.o2o.pn.enums.WechatAuthStateEnum;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.Assert.assertEquals;
//
//public class LocalAuthServiceTest extends BaseTest {
//    @Autowired
//    private LocalAuthService localAuthService;
//    @Test
//    public void testABindLocalAuth(){
//        //新增一条平台账号
//        LocalAuth localAuth =new LocalAuth();
//        PersonInfo personInfo =new PersonInfo();
//        String username = "testusername";
//        String password = "testoassword";
//        //给平台账号设置用户信息
//        //给用户设置用户ID标明是某个用户创建的账号
//        personInfo.setUserId(1L);
//        //给平台账号设置用户信息，标明是哪个用户绑定
//        localAuth.setPersonInfo(personInfo);
//        //设置账号
//        localAuth.setUsername(username);
//        //设置密码
//        localAuth.setPassword(password);
//        //绑定账号
//        LocalAuthExecution lae = localAuthService.bindLocalAuth(localAuth);
//        assertEquals(WechatAuthStateEnum.SUCCESS.getState(),lae.getState());
//        //通过userId找到新增的localAuth
//        localAuth = localAuthService.getLocalAuthByUserId(personInfo.getUserId());
//        //打印用户名字和账号密码看看跟预期是否相等
//            System.out.println("用户昵称："+localAuth.getPersonInfo().getName());
//            System.out.println("平台账号密码："+localAuth.getPassword());
//
//    }
//    @Test
//    public void testBModifyLocalAuth(){
//        //设置账号
//        long userId = 1;
//        String username = "testusername";
//        String password = "testoassword";
//        String newPassword = "testnewpassword";
//        //修改账号对应的密码
//        LocalAuthExecution lae = localAuthService.modifyLocalAuth(userId,username,password,newPassword);
//        assertEquals(WechatAuthStateEnum.SUCCESS.getState(),lae.getState());
//        //通过账号密码找到修改后的localAuth
//        LocalAuth localAuth  = localAuthService.getLocalAuthByUsernameAndPwd(username,newPassword);
//        //打印用户名字看看和预期是否想否
//        System.out.println(localAuth.getPersonInfo().getName());
//    }
//
//}
