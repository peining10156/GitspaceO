package com.o2o.pn.dao;

import com.o2o.pn.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCategoryDao {


    List<ShopCategory> queryShopCategory(@Param("ShopCategoryCondition") ShopCategory shopCategory);
}
