package com.o2o.pn.dao;

import com.o2o.pn.entity.WechatAuth;

public interface WechatAuthDao {

    /*
    *
    * 通过openId查询对应本平台的的微信账号
    * @param openId
    *
    * */
    WechatAuth queryWechatAuthByOpenId(String openId);

    /*
    * 添加对应本平台的微信账号
    *@param wechatAuth
    * */
    int insertWechatAuth(WechatAuth wechatAuth);
}
