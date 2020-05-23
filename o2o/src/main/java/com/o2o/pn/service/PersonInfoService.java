package com.o2o.pn.service;

import com.o2o.pn.entity.PersonInfo;

public interface PersonInfoService {
    /*
    * 根据用户ID获取personInfo信息
    * @param userId;
    *
    * */
    PersonInfo getPersonInfoById(Long userId);
}
