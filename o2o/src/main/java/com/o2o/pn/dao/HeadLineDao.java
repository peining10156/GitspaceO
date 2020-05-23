package com.o2o.pn.dao;

import com.o2o.pn.entity.HeadLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HeadLineDao {

    /*
    * 根据出入的查询的条件查询（头条名查询头条）
    *
    * */
    List<HeadLine>queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);
}
