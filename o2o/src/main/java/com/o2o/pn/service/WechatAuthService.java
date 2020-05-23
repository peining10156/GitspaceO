package com.o2o.pn.service;

import com.o2o.pn.dto.WechatAuthExecution;
import com.o2o.pn.entity.WechatAuth;
import com.o2o.pn.exceptions.WeChatAuthOperationException;

public interface WechatAuthService {

    /*
    *
    * 通过openID查找平台对应的微信账号
    *
    * */
    WechatAuth getWechatAuthByOpenId(String openId);
    /*
    *
    * 注册本平台的微信账号
    *
    *
    * */
    WechatAuthExecution register(WechatAuth wechatAuth)throws WeChatAuthOperationException;
}
