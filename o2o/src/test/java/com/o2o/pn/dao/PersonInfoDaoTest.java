//package com.o2o.pn.dao;
//
//import com.o2o.pn.BaseTest;
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
//public class PersonInfoDaoTest extends BaseTest {
//    @Autowired
//    private PersonInfoDao personInfoDao;
//    @Test
//    public void testAInsertPersonInfo()throws Exception{
//        //设置新增的用户信息
//        PersonInfo personInfo =new PersonInfo();
//        personInfo.setName("裴宁");
//        personInfo.setGender("男");
//        personInfo.setUserType(1);
//        personInfo.setCreateTime(new Date());
//        personInfo.setLastEditTime(new Date());
//        personInfo.setEnableStatus(1);
//        int effectedNum=personInfoDao.insertPersonInfo(personInfo);
//        assertEquals(1,effectedNum);
//    }
//    @Test
//    public void testBQueryPersonInfoById(){
//        long userId = 2;
//        //查询用户ID为1的用户信息
//        PersonInfo personInfo = personInfoDao.queryPersonInfoById(userId);
//        System.out.println(personInfo.getName());
//    }
//}
