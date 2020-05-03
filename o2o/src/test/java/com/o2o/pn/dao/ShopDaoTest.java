package com.o2o.pn.dao;

import com.o2o.pn.BaseTest;
import com.o2o.pn.entity.Area;
import com.o2o.pn.entity.PersonInfo;
import com.o2o.pn.entity.Shop;
import com.o2o.pn.entity.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;
public class ShopDaoTest extends BaseTest {

    @Autowired
     private ShopDao shopDao;

    @Test
    @Ignore
    public void testInsertShopDao() {
         Shop shop=new Shop();
    PersonInfo owner = new PersonInfo();
    Area area = new Area();
    ShopCategory shopCategory =new ShopCategory();
    owner.setUserId(1L);
    area.setAreId(2);
    shopCategory.setShopCategoryId(1L);
    shop.setArea(area);
    shop.setOwner(owner);
    shop.setShopCategory(shopCategory);
    shop.setShopName("面对疾风吧奶茶店");
    shop.setShopDesc("test");
    shop.setShopAddr("河北张家口市怀来县沙城镇");
    shop.setPhone("18600178719");
    shop.setShopImg("www");
    //shop.setPriority(1);
    shop.setEnableStatus(1);
    shop.setCreateTime(new Date());
    shop.setAdvice("审核中");
    int effectedNum =shopDao.insertShop(shop);
        assertEquals(1,effectedNum);

    }
    @Test
    public void testUpdateShopDao(){

        Shop shop=new Shop();
        shop.setShopId(4L);

        shop.setShopDesc("大碗宽面奶茶");
        shop.setShopAddr("河北张家口市怀来");
        shop.setLastEditTime(new Date());
        int effectedNum =shopDao.updateShop(shop);
        assertEquals(1,effectedNum);
    }
}
