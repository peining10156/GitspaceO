//package com.o2o.pn.dao;
//
//import com.o2o.pn.BaseTest;
//import com.o2o.pn.entity.LocalAuth;
//import com.o2o.pn.entity.PersonInfo;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//
//import static org.junit.Assert.assertEquals;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class LocalAuthDaoTest extends BaseTest {
//    @Autowired
//    private LocalAuthDao localAuthDao;
//    private static final String username = "testusername";
//    private static final String password = "testpassword";
//
//    @Test
//    public void testAInsertLocalAuth() throws Exception{
//
//    //新增一条平台账号信息
//        LocalAuth localAuth=new LocalAuth();
//        PersonInfo personInfo =new PersonInfo();
//        //给平台账号绑定上用户信息
//        personInfo.setUserId(1L);
//        localAuth.setPersonInfo(personInfo);
//        //设置上用户名和密码
//        localAuth.setPassword(password);
//        localAuth.setUsername(username);
//        int effectedNum = localAuthDao.insertLocalAuth(localAuth);
//        assertEquals(1,effectedNum);
//    }
//    @Test
//    public void testBQueryLocalByUserNameAndPwd()throws Exception{
//        //按照账号和密码查询用户信息
//        LocalAuth localAuth = localAuthDao.queryLocalByUserNameAndPwd(username,password);
//        assertEquals("胡军",localAuth.getPersonInfo().getName());
//    }
//    @Test
//    public void testCQueryLocalByUseeId()throws Exception{
//        //按照用户ID查询平台账号，进而获取用户信息
//        LocalAuth localAuth = localAuthDao.queryLocalByUserId(1L);
//        assertEquals("胡军",localAuth.getPersonInfo().getName());
//
//    }
//    @Test
//    public void testDUpdateLocalAuth()throws Exception{
//        Date now = new Date();
//        int effectedNum = localAuthDao.updateLocalAuth(1L,username,password,password+"new",now);
//        assertEquals(1,effectedNum);
//        //查询出该条平台账号的最新信息。
//        LocalAuth localAuth =localAuthDao.queryLocalByUserId(1L);
//        //输出新密码
//        System.out.println(localAuth.getPassword());
//    }
//
//
//}
