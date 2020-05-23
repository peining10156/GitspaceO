package com.o2o.pn.dao;

import com.o2o.pn.entity.PersonInfo;

public interface PersonInfoDao {


    /*
    * 通过用户ID 查询用户
    * */
    PersonInfo queryPersonInfoById(long userId);
    /*
    * 添加用户信息
    * */
    int insertPersonInfo(PersonInfo personInfo);

}
