package com.o2o.pn.service.impl;

import com.o2o.pn.dao.ShopDao;
import com.o2o.pn.dto.ShopExecution;
import com.o2o.pn.entity.Shop;
import com.o2o.pn.enums.ShopStateEnum;
import com.o2o.pn.exceptions.ShopOperationException;
import com.o2o.pn.service.ShopService;
import com.o2o.pn.util.ImageUtil;
import com.o2o.pn.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;

@Service
public class ShopServiceImpl implements ShopService{

        @Autowired
    private ShopDao shopDao;
        @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName){
        //控制判断
    if(shop == null){
        return new ShopExecution(ShopStateEnum.NULL_SHOP);
    }
    try {

        //给店铺信息赋初始值
        shop.setEnableStatus(0);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        //添加店铺信息
        int effectedNum = shopDao.insertShop(shop);
        if(effectedNum <=0){
            throw new ShopOperationException("创建店铺失败");
        }else{
            if(shopImgInputStream != null){

                try {
                    //存储图片
                    addShopImg(shop, shopImgInputStream ,fileName);
                   //shop.getShopImg();
                }catch (Exception e){
                    throw new ShopOperationException("addShopImgg error:"+e.getMessage());
                }
                //更新店铺地址
                 effectedNum = shopDao.updateShop(shop);
                if (effectedNum<=0){
                    throw new ShopOperationException("更新店铺地址失败");
                }
            }
        }
    }catch (Exception e){
        throw new ShopOperationException("addShop error:" + e.getMessage());
    }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
        }

    private void addShopImg(Shop shop, InputStream shopImgInputStream,String fileName ) {

            //获取shop图片目录的相对路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());

        System.out.print("ShopImgAddr========="+dest);

        String ShopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream,fileName,dest);
        shop.setShopImg(ShopImgAddr);
        System.out.print("ShopImgAddr========="+ShopImgAddr);
    }


}
