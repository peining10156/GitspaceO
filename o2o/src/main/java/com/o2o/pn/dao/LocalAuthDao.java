package com.o2o.pn.dao;

import com.o2o.pn.entity.LocalAuth;
import org.apache.ibatis.annotations.Param;

import java.util.Date;


public interface LocalAuthDao {
    /*
    * 通过账号和密码查询对应信息，登录用
    * @param username
    * @param password
    * @return
    *
    * */
    LocalAuth queryLocalByUserNameAndPwd(@Param("username")String username ,@Param("password")String password);

    /*
    * 通过用户Id查询对应localAuth
    * @param userId
    * */
    LocalAuth queryLocalByUserId(@Param("userId") long userId);
    /*
    * 添加平台账号
    *
    * */
    int insertLocalAuth(LocalAuth localAuth);
    /*
    * userId username password 更改密码
    *
    * */
    int updateLocalAuth(@Param("userId") Long userId, @Param("username")String username,
                        @Param("password")String password, @Param("newPassword")String newPassword,
                        @Param("lastEditTime")Date lastEditTime);
}
