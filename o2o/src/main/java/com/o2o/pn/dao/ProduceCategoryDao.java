package com.o2o.pn.dao;

import com.o2o.pn.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProduceCategoryDao {

    /*
     * 查询某个指定店铺下的所有商品类别
     *
     * @param long shopId
     * @return list<ProductCategory>
     * */

    List<ProductCategory> queryProductCategoryList(Long shopId);

    /*
    * 批量添加商品类别,int是影响的行数，添加了多少
    *
    * */
    int batchInsertProductCategory(List<ProductCategory>productCategoryList);

    /*
    *
    * 删除指定商品类别
    *
    * */
    int deleteProductCategory(@Param("productCategoryId")long productCategoryId, @Param("shopId") long shopId);

}
