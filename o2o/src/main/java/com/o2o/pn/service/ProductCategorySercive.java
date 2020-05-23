package com.o2o.pn.service;

import com.o2o.pn.dto.ProductCategoryExecution;
import com.o2o.pn.entity.ProductCategory;
import com.o2o.pn.exceptions.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategorySercive {

    /*
    * 查询某个指定店铺下的所有商品类别
    *
    * @param long shopId
    * @return list<ProductCategory>
    * */

    List<ProductCategory>getProductCategoryList(Long shopId);

    /*
    *
    * 批量添加商品类别
    *用事务来管理需要继RuntimeException
    * */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory>productCategoryList)
    throws ProductCategoryOperationException;

    /*
    *
    * 将此类别下的商品里的类别ID置为空，在删除掉该商品类别
    *
    *
    * */
    ProductCategoryExecution deleteProductGory(long productCategoryId,long shopId)throws ProductCategoryOperationException;

}
