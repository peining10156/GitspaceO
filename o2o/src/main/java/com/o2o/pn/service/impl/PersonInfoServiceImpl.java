package com.o2o.pn.service.impl;

import com.o2o.pn.dao.PersonInfoDao;
import com.o2o.pn.entity.PersonInfo;
import com.o2o.pn.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    private PersonInfoDao personInfoDao;
    @Override
    public PersonInfo getPersonInfoById(Long userId) {
        return  personInfoDao.queryPersonInfoById(userId);
    }
}
