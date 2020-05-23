package com.o2o.pn.dao;

import com.o2o.pn.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCategoryDao {

/*
* 更具查询条件返回ShopCategory列表
*
* */
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
