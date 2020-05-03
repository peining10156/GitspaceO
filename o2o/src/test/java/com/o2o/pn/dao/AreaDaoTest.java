package com.o2o.pn.dao;

import com.o2o.pn.BaseTest;
import com.o2o.pn.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaDaoTest extends BaseTest {

    @Autowired
    private AreaDao areaDao;
    @Test
    public void   testqueryArea(){
        List<Area>areaList= areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

}
