package com.o2o.pn.dao;

import com.o2o.pn.BaseTest;
import com.o2o.pn.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class ShopCategpryTest extends BaseTest {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void testQueryShopCategory(){

        List<ShopCategory> ShopCategoryList= shopCategoryDao.queryShopCategory(new ShopCategory());
        assertEquals(2,ShopCategoryList.size());
        ShopCategory test= new ShopCategory();
        ShopCategory parent = new ShopCategory();
        parent.setShopCategoryId(1L);
        test.setParent(parent);

        ShopCategoryList = shopCategoryDao.queryShopCategory(test);

        assertEquals(1,ShopCategoryList.size());
        System.out.print(ShopCategoryList.get(0).getShopCategoryName());



    }


}
