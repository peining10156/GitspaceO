package com.o2o.pn.service;

import com.o2o.pn.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {

    public static final String SCLISTKEY = "shopcategorylist";

    /*
    * 根据查询条件返回查询列表
    * */
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
