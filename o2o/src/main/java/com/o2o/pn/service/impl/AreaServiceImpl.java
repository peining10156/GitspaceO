package com.o2o.pn.service.impl;

import com.o2o.pn.dao.AreaDao;
import com.o2o.pn.entity.Area;
import com.o2o.pn.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList(){

        return areaDao.queryArea();
    }


}