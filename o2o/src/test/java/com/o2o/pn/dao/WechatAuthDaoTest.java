//package com.o2o.pn.dao;
//
//import com.o2o.pn.BaseTest;
//import com.o2o.pn.entity.PersonInfo;
//import com.o2o.pn.entity.WechatAuth;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//
//import static org.junit.Assert.assertEquals;
//
//public class WechatAuthDaoTest extends BaseTest {
//    @Autowired
//    private WechatAuthDao wechatAuthDao;
//    @Test
//    public  void testAInsertWechatAuth()throws Exception{
//
//        //新增一条微信号
//        WechatAuth wechatAuth = new WechatAuth();
//        PersonInfo personInfo =new PersonInfo();
//        personInfo.setUserId(1L);
//        wechatAuth.setPersonInfo(personInfo);
//        //随意设置上openId
//        wechatAuth.setOpenId("5646546546123fgfg");
//        wechatAuth.setCreateTime(new Date());
//        int effectedNum = wechatAuthDao.insertWechatAuth(wechatAuth);
//        assertEquals(1,effectedNum);
//    }
//    @Test
//    public void testBQueryWechatAuthByOpinId(){
//        WechatAuth wechatAuth = wechatAuthDao.queryWechatAuthByOpenId("5646546546123fgfg");
//        assertEquals("胡军",wechatAuth.getPersonInfo().getName());
//    }
//}
