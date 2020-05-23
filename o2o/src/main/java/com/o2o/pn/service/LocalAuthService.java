package com.o2o.pn.service;

import com.o2o.pn.dto.LocalAuthExecution;
import com.o2o.pn.entity.LocalAuth;
import com.o2o.pn.exceptions.LocalAuthOperationException;


public interface LocalAuthService {

    /*
    * 通过账号和密码获取平台账号信息
    * */
    LocalAuth getLocalAuthByUsernameAndPwd(String userName,String passWord);
    /*
    * 通过userId获取平台账号信息
    *
    * */
    LocalAuth getLocalAuthByUserId(long userId);
    /*
    * 绑定微信，生成平台专属的账号
    * @param localAuth
    * @return
    * @throws RuntimeException
    * */
    LocalAuthExecution bindLocalAuth(LocalAuth localAuth) throws LocalAuthOperationException;

    /*
    * 修改平台账号密码
    *@param localAuthId
    * @param userName
    * @param password
    * @param newPassWord
    * @param lastEditTime
    * @return
    * */
    LocalAuthExecution modifyLocalAuth(Long userId,String username,String password,String newPassword)
        throws LocalAuthOperationException;


}
