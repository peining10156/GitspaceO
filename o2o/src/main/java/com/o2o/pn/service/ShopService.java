package com.o2o.pn.service;

import com.o2o.pn.dto.ShopExecution;
import com.o2o.pn.entity.Shop;

import java.io.InputStream;

public interface ShopService{

//    ShopExecution addShop(Shop shop, File shopImg);
        ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName);

}
