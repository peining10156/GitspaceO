package com.o2o.pn.service.impl;

import com.o2o.pn.dao.ShopDao;
import com.o2o.pn.dto.ImageHolder;
import com.o2o.pn.dto.ShopExecution;
import com.o2o.pn.entity.Shop;
import com.o2o.pn.enums.ShopStateEnum;
import com.o2o.pn.exceptions.ShopOperationException;
import com.o2o.pn.service.ShopService;
import com.o2o.pn.util.ImageUtil;
import com.o2o.pn.util.PageCalculator;
import com.o2o.pn.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{

        @Autowired
    private ShopDao shopDao;

        /*
        * 获取店铺列表
        *
        * */
    @Override
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {

       int rowIndex =PageCalculator.calculateRowIndex(pageIndex,pageSize);
        List<Shop>shopList = shopDao.queryShopList(shopCondition,rowIndex,pageSize);
        int count =shopDao.queryShopCount(shopCondition);
        ShopExecution se = new ShopExecution();
        if (shopList !=null){
            se.setShopList(shopList);
            se.setCount(count);
        }else {
            se.setState(ShopStateEnum.INNER_ERROR.getState());
        }
        return se;
    }
/*
* 获取店铺ID
*
* */
    @Override
    public Shop shopByShopId(Long shopId) {
        return shopDao.queryByShopId(shopId);
    }
/*
*
* 修改店铺信息
* */
    @Override
    //重构前
    // public ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException
    public ShopExecution modifyShop(Shop shop,ImageHolder thumbnail) throws ShopOperationException {
        //1.判断是否需要修改图片信息
        if(shop ==null||shop.getShopId()==null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }else {
            try {

                //1.判断是否需要处理图片
                if (thumbnail.getImage() != null && thumbnail.getImageName() != null && !"".equals(thumbnail.getImageName())) {
                    Shop tempStop = shopDao.queryByShopId(shop.getShopId());
                    if (tempStop.getShopImg() != null) {
                        ImageUtil.deleteFileOrPath(tempStop.getShopImg());
                    }
                    addShopImg(shop,thumbnail);
                }

                //2.更新店铺信息
                shop.setLastEditTime(new Date());
                int effectedNum = shopDao.updateShop(shop);
                if (effectedNum <= 0) {
                    return new ShopExecution(ShopStateEnum.INNER_ERROR);
                } else {
                    shop = shopDao.queryByShopId(shop.getShopId());
                    return new ShopExecution(ShopStateEnum.SUCCESS, shop);
                }
            }catch (Exception e){
                throw new ShopOperationException("modifyShop error:"+ e.getMessage());
            }
        }

    }

    /*
    *
    * 添加店铺信息
    * */
    @Override
    @Transactional
    //重构前
   // public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName){
    public ShopExecution addShop(Shop shop, ImageHolder thumbnail){
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
            //改造前
           // if(shopImgInputStream != null){
            if(thumbnail.getImage() != null){

                try {
                    //存储图片
                    //改造前
                    //addShopImg(shop, shopImgInputStream ,fileName);
                    addShopImg(shop,thumbnail);
                   //shop.getShopImg();
                }catch (Exception e){
                    throw new ShopOperationException("addShopImg error:"+e.getMessage());
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
/*
*
* 插入店铺图片
* */
    //改造前
    //private void addShopImg(Shop shop, InputStream shopImgInputStream,String fileName ) {
    private void addShopImg(Shop shop,ImageHolder thumbnail ) {

            //获取shop图片目录的相对路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());

        System.out.print("ShopImgAddr========="+dest);
        //改造前
        //String ShopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream,fileName,dest);
        String ShopImgAddr = ImageUtil.generateThumbnail(thumbnail,dest);
        shop.setShopImg(ShopImgAddr);
        System.out.print("ShopImgAddr========="+ShopImgAddr);
    }


}
