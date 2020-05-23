package com.o2o.pn.service;

import com.o2o.pn.dto.ImageHolder;
import com.o2o.pn.dto.ShopExecution;
import com.o2o.pn.entity.Shop;
import com.o2o.pn.exceptions.ShopOperationException;

public interface ShopService{

        /*
        *根据shopCondition分页返回相应店铺列表数据。
        *
        * */
        public ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);

        /*
        * 通过店铺ID获取店铺信息
        * @param shopId
        * */
        Shop shopByShopId(Long shopId);
        /*
         *更新店铺信息包含对图片的处理
         *
         * */
        ShopExecution modifyShop(Shop shop,ImageHolder thumbnail)throws ShopOperationException;


        /*
        * 注册店铺信息包含店铺处理
        * @param shop
        * @param shopImgInputStream
        * @param file name
        * @return
        * @throws ShopOperationException
        *
        * */
//    ShopExecution addShop(Shop shop, File shopImg);
        //改造前
       // ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName);
        //改造后
        ShopExecution addShop(Shop shop, ImageHolder thumbnail);

}
