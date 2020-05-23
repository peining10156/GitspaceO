package com.o2o.pn.service;

import com.o2o.pn.dto.ImageHolder;
import com.o2o.pn.dto.ProductExecution;
import com.o2o.pn.entity.Product;
import com.o2o.pn.exceptions.ProductOperationException;

import java.util.List;

public interface ProductService {


    /*
    * 添加商品信息以及处理图片
    *  @param product
    *  @param thumbanil
    *  @param productImgs
    *  @return
    *  @throws ProductOperationException
    * */
    ProductExecution addProduct(Product product,ImageHolder thumbnail,List<ImageHolder>productImgHolderList) throws ProductOperationException;

 /*
 * 查询商品列表并分页，可输入的条件有：商品名（模糊），商品状态，店铺ID，商品类别
 * @param productCondition
 * @param pageIndex
 *@param pageSize
 *return
 * */

 ProductExecution getProductList(Product productCondition,int pageIndex,int pageSize);
  /*
  * 通过商品ID查询唯一的商品信息
  * @param productId
  * @return
  * */
  Product getProductById(long productId);
  /*
  * 修改商品信息以及图片处理
  *@param product
  *@param thumbanil
  *@param productImgs
  *@throws ProductOperationException
  * */
  ProductExecution modifyProduct(Product product,ImageHolder thumbanil,List<ImageHolder> productImgHolderList)
  throws ProductOperationException;
}
