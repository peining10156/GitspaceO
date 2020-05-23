package com.o2o.pn.dao;

import com.o2o.pn.entity.ProductImg;

import java.util.List;

public interface ProductImgDao {

    List<ProductImg> queryProductImgList(long productId);
    /*
     *批量添加商品图片
     *@param productImgList
     *@return
     * */
    int batchInsertProductImg(List<ProductImg>productImgList);
    /*
     *
     * 删除指定商品下的所有详情图
     *
     * */
   int deleteProductImgByProductId(long productId);



}
