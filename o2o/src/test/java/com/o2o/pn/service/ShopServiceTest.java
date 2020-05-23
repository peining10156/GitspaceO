//package com.o2o.pn.service;
//
//import com.o2o.pn.BaseTest;
//import com.o2o.pn.dto.ImageHolder;
//import com.o2o.pn.dto.ShopExecution;
//import com.o2o.pn.entity.Area;
//import com.o2o.pn.entity.PersonInfo;
//import com.o2o.pn.entity.Shop;
//import com.o2o.pn.entity.ShopCategory;
//import com.o2o.pn.enums.ShopStateEnum;
//import com.o2o.pn.exceptions.ShopOperationException;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//import java.util.Date;
//
//import static org.junit.Assert.assertEquals;
//
//public class ShopServiceTest extends BaseTest {
//    @Autowired
// private ShopService shopService;
//
//    @Test
//    public void testGetShopList(){
//
//        Shop shopCondition = new Shop();
//        ShopCategory sc = new ShopCategory();
//        sc.setShopCategoryId(1L);
//        shopCondition.setShopCategory(sc);
//        ShopExecution SE = shopService.getShopList(shopCondition,3,4);
//        System.out.println("店铺列表数为："+ SE.getShopList().size());
//        System.out.println("店铺总数："+ SE.getCount());
//
//    }
//
//    @Test
//    public void testModifyShop() throws ShopOperationException,FileNotFoundException{
////       Shop shop =shopService.shopByShopId(3L);
//        Shop shop =new Shop();
//        shop.setShopId(79L);
//        shop.setShopName("修改后的店铺名称");
////        PersonInfo owner =new PersonInfo();
////        owner.setUserId(1L);
////        shop.setOwner(owner);
//        File shopImg = new File("D:/image/baoerjie.jpg");
//        InputStream is = new FileInputStream(shopImg);
//
//        ImageHolder imageHolder = new ImageHolder(is,"baoerjie.jpg");
//        ShopExecution shopExecution = shopService.modifyShop(shop,imageHolder);
//     //   System.out.println("修改后的图片地址为："+shopExecution.getShop().getShopId());
//
//    }
//
//
//    @Test
//    public void testAddShop()throws ShopOperationException,FileNotFoundException {
//
//        Shop shop=new Shop();
//        PersonInfo owner = new PersonInfo();
//        Area area = new Area();
//        ShopCategory shopCategory =new ShopCategory();
//        owner.setUserId(1L);
//        area.setAreaId(2);
//        shopCategory.setShopCategoryId(1L);
//        shop.setArea(area);
//        shop.setOwner(owner);
//        shop.setShopCategory(shopCategory);
//        shop.setShopName("测试店铺ADC");
//        shop.setShopDesc("testADC");
//        shop.setShopAddr("河北张家口");
//        shop.setPhone("18600178719");
//        shop.setCreateTime(new Date());
//        //shop.setPriority(1);
//        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
//        shop.setAdvice("审核中");
//        File shopImg = new File("D:/image/baoerjie.jpg");
//        //改造file实例
//        InputStream is = new FileInputStream(shopImg);
//        ImageHolder imageHolder = new ImageHolder(is,"baoerjie.jpg");
//        ShopExecution se = shopService.addShop(shop,imageHolder);
//        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
//    }
//
//}
