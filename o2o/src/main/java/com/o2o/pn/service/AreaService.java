package com.o2o.pn.service;

import com.o2o.pn.entity.Area;

import java.util.List;

public interface AreaService {

    public  static final String AREALISTKEY = "arealist";

    List<Area> getAreaList();
}
