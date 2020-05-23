//package com.o2o.pn.dao;
//
//import com.o2o.pn.BaseTest;
//import com.o2o.pn.entity.Area;
//import com.o2o.pn.entity.PersonInfo;
//import com.o2o.pn.entity.Shop;
//import com.o2o.pn.entity.ShopCategory;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//public class ShopDaoTest extends BaseTest {
//
//    @Autowired
//     private ShopDao shopDao;
//
//    @Test
//    public void testQueryShopListAndCount(){
////二级类别下边的店铺
//            Shop shopCondition = new Shop();
//            ShopCategory childCategory = new ShopCategory();
//            ShopCategory parentCategory = new ShopCategory();
//            parentCategory.setShopCategoryId(2L);
//            childCategory.setParent(parentCategory);
//        shopCondition.setShopCategory(childCategory);
//        List<Shop> shopList=  shopDao.queryShopList(shopCondition,0,6);
//        int count =shopDao.queryShopCount(shopCondition);
//        System.out.println("店铺列表的大小："+ shopList.size());
//        System.out.println("店铺总数："+ count);
//
////        Shop shopCondition = new Shop();
////        PersonInfo owner =new PersonInfo ();
////        owner.setUserId(1L);
////        shopCondition.setOwner(owner);
////        List<Shop> shopList=  shopDao.queryShopList(shopCondition,0,3);
////        int count =shopDao.queryShopCount(shopCondition);
////        System.out.println("店铺列表的大小："+ shopList.size());
////        System.out.println("店铺总数："+ count);
//
//
//    }
//
//    @Test
//    public void testQueryByShopId(){
//        long shopId=79L;
//        Shop shop=shopDao.queryByShopId(shopId);
//        System.out.println("areaId:" + shop.getArea().getAreaId());
//        System.out.println("areaName:" + shop.getArea().getAreaName());
//    }
//
//    @Test
//   @Ignore
//    public void testInsertShopDao() {
//         Shop shop=new Shop();
//    PersonInfo owner = new PersonInfo();
//    Area area = new Area();
//    ShopCategory shopCategory =new ShopCategory();
//    owner.setUserId(1L);
//    area.setAreaId(2);
//    shopCategory.setShopCategoryId(1L);
//    shop.setArea(area);
//    shop.setOwner(owner);
//    shop.setShopCategory(shopCategory);
//    shop.setShopName("面对疾风吧奶茶店");
//    shop.setShopDesc("test");
//    shop.setShopAddr("河北张家口市怀来县沙城镇");
//    shop.setPhone("18600178719");
//    shop.setShopImg("www");
//    //shop.setPriority(1);
//    shop.setEnableStatus(1);
//    shop.setCreateTime(new Date());
//    shop.setAdvice("审核中");
//    int effectedNum =shopDao.insertShop(shop);
//        assertEquals(1,effectedNum);
//
//    }
//    @Test
//    @Ignore
//    public void testUpdateShopDao(){
//
//        Shop shop=new Shop();
//        shop.setShopId(79L);
//        shop.setShopName("破玩意坑爹呢");
//        shop.setShopDesc("大碗宽面奶茶");
//        shop.setShopAddr("河北张家口市怀来");
//        shop.setLastEditTime(new Date());
//        int effectedNum =shopDao.updateShop(shop);
//        assertEquals(1,effectedNum);
//    }
//}
