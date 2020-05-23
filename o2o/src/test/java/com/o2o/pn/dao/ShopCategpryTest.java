//package com.o2o.pn.dao;
//
//import com.o2o.pn.BaseTest;
//import com.o2o.pn.entity.ShopCategory;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
//public class ShopCategpryTest extends BaseTest {
//
//    @Autowired
//    private ShopCategoryDao shopCategoryDao;
//
//    @Test
//    public void testQueryShopCategory(){
//        List<ShopCategory> ShopCategoryList= shopCategoryDao.queryShopCategory(null);
//            System.out.println("没有父类ID的条数为："+ ShopCategoryList.size() +ShopCategoryList.get(0).getShopCategoryName() + "/br" +ShopCategoryList.get(1).getShopCategoryName()+"/br"+ShopCategoryList.get(2).getShopCategoryName());
////        List<ShopCategory> ShopCategoryList= shopCategoryDao.queryShopCategory(new ShopCategory());
////        assertEquals(1,ShopCategoryList.size());
////        ShopCategory test= new ShopCategory();
////        ShopCategory parent = new ShopCategory();
////        parent.setShopCategoryId(1L);
////        test.setParent(parent);
////
////        ShopCategoryList = shopCategoryDao.queryShopCategory(test);
////
////        assertEquals(1,ShopCategoryList.size());
////        System.out.print(ShopCategoryList.get(0).getShopCategoryName());
//
//
//
//    }
//
//
//}
