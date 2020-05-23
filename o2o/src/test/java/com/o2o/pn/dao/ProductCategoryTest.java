//package com.o2o.pn.dao;
//
//import com.o2o.pn.BaseTest;
//import com.o2o.pn.entity.ProductCategory;
//import com.o2o.pn.exceptions.ShopOperationException;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)//按照获得的方法指定的执行测试方法testA testB testC
//public class ProductCategoryTest extends BaseTest {
//    @Autowired
//    private ProduceCategoryDao produceCategoryDao;
//    /*
//    *
//    * 测试商品类别总数
//    * */
//    @Test
//    public void testBProductCategoryDao()throws ShopOperationException {
//
//        long shopId= 79;
//    List<ProductCategory>productCategoryList=produceCategoryDao.queryProductCategoryList(shopId);
//
//    System.out.println("商品类别总数为：" + productCategoryList.size());
//
//    }
//    @Test
//    public void testABatchInsertProductCategory(){
//
//        ProductCategory productCategory1 = new ProductCategory();
//        productCategory1.setProductCategoryName("红茶1");
//        productCategory1.setShopId(79L);
//        productCategory1.setCreateTime(new Date());
//        productCategory1.setPriority(2);
//        ProductCategory productCategory2 = new ProductCategory();
//        productCategory2.setProductCategoryName("红茶2");
//        productCategory2.setShopId(79L);
//        productCategory2.setCreateTime(new Date());
//        productCategory2.setPriority(3);
//        List<ProductCategory>productCategoryList = new ArrayList<ProductCategory>();
//        productCategoryList.add(productCategory1);
//        productCategoryList.add(productCategory2);
//
//        int effectdeNum = produceCategoryDao.batchInsertProductCategory(productCategoryList);
//        assertEquals(2,effectdeNum);
//
//    }
//    @Test
//    public void testCDeleteeProductCategory()throws Exception{
//        long shopId = 79;
//        List<ProductCategory>productCategoryList = produceCategoryDao.queryProductCategoryList(shopId);
//        for (ProductCategory PC:productCategoryList){
//            if("红茶1".equals(PC.getProductCategoryName())||"红茶2".equals(PC.getProductCategoryName())){
//                int effectedNum = produceCategoryDao.deleteProductCategory(PC.getProductCategoryId(),shopId);
//                assertEquals(1,effectedNum);
//
//            }
//        }
//
//    }
//}
//
