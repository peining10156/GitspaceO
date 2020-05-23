//package com.o2o.pn.dao;
//
//import com.o2o.pn.BaseTest;
//import com.o2o.pn.entity.Product;
//import com.o2o.pn.entity.ProductCategory;
//import com.o2o.pn.entity.ProductImg;
//import com.o2o.pn.entity.Shop;
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
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class ProductDaoTest extends BaseTest {
//
//    @Autowired
//   private ProductDao productDao;
//    @Autowired
//    private ProductImgDao productImgDao;
//
//    /*
//    *
//    * 添加商品测试
//    * */
//    @Test
//    public void testAInsertProduct()throws Exception{
//
//        Shop shop =new Shop();
//        shop.setShopId(79L);
//        ProductCategory pc1=new ProductCategory();
//        pc1.setProductCategoryId(52L);
//        //初始化三个商品实例并添加进店铺ID为79的店铺里
//        //同时商品类别的ID为52
//        Product product1 = new Product();
//        product1.setProductName("测试商品1");
//        product1.setProductDesc("测试desc1");
//        product1.setImgAddr("test1");
//        product1.setPriority(99);
//        product1.setEnableStatus(1);
//        product1.setCreateTime(new Date());
//        product1.setLastEditTime(new Date());
//        product1.setProductCategory(pc1);
//        product1.setShop(shop);
//
//        Product product2 = new Product();
//        product2.setProductName("测试商品2");
//        product2.setProductDesc("测试desc2");
//        product2.setImgAddr("test2");
//        product2.setPriority(98);
//        product2.setEnableStatus(1);
//        product2.setCreateTime(new Date());
//        product2.setLastEditTime(new Date());
//        product2.setProductCategory(pc1);
//        product2.setShop(shop);
//
//        Product product3 = new Product();
//        product3.setProductName("测试商品3");
//        product3.setProductDesc("测试desc3");
//        product3.setImgAddr("test3");
//        product3.setPriority(97);
//        product3.setEnableStatus(1);
//        product3.setCreateTime(new Date());
//        product3.setLastEditTime(new Date());
//        product3.setProductCategory(pc1);
//        product3.setShop(shop);
//
//        //判断商品是否添加成功
//        int effectedNum = productDao.insertProduct(product1);
//             assertEquals(1,effectedNum);
//             effectedNum = productDao.insertProduct(product2);
//             assertEquals(1,effectedNum);
//            effectedNum = productDao.insertProduct(product3);
//            assertEquals(1,effectedNum);
//
//    }
//    @Test
//    public void teseCQueryProductByProductId()throws Exception{
//        long productId = 1;
//        //初始化两个商品详情图是咧作为productI为1的商品下的详情图。
//        //批量插入到商品详情图表中
//        ProductImg productImg1 = new ProductImg();
//        productImg1.setImgAddr("图片1");
//        productImg1.setImgDesc("test图片1");
//        productImg1.setPriority(1);
//        productImg1.setCreateTime(new Date());
//        productImg1.setProductId(productId);
//
//        ProductImg productImg2 = new ProductImg();
//        productImg2.setImgAddr("图片2");
//        productImg2.setImgDesc("test图片22");
//        productImg2.setPriority(1);
//        productImg2.setCreateTime(new Date());
//        productImg2.setProductId(productId);
//        List<ProductImg> productImgList = new ArrayList<ProductImg>();
//        productImgList.add(productImg1);
//        productImgList.add(productImg2);
//
//        int effectedNum  = productImgDao.batchInsertProductImg(productImgList);
//        assertEquals(2,effectedNum);
//        //查询productId为1的商品信息并校验返回的详情图实例列表size是否为2
//        Product product = productDao.queryProductById(productId);
//        assertEquals(2,product.getProductImgList().size());
//        //删除新增的这两个商品详情图实例
//        effectedNum = productImgDao.deleteProductImgByProductId(productId);
//        assertEquals(2,effectedNum);
//    }
//    @Test
//        public void testDUpdateProduct()throws Exception{
//
//        Product product =new Product();
//        ProductCategory pc = new ProductCategory();
//        Shop shop =new Shop();
//        shop.setShopId(79L);
//        pc.setProductCategoryId(52L);
//        product.setProductId(1L);
//        product.setShop(shop);
//        product.setProductName("第二个产品");
//        product.setProductCategory(pc);
//        //修改productI为1 的商品的名称
//        //以及商品类别并校验影响的行数书否为1
//        int effectedNum = productDao.updateProduct(product);
//        assertEquals(1,effectedNum) ;
//    }
//    @Test
//        public void testBqueryProductList()throws Exception{
//        Product productCondition =new Product();
//        //分页查询预期返回3条结果
//        List<Product>productList = productDao.queryProductList(productCondition,0,3);
//        assertEquals(3,productList.size());
//        //查询名称为测试的商品总数
//        int count = productDao.queryProductCount(productCondition);
//        assertEquals(11,count);
//        //使用商品名称模糊查询，预期返回三条条结果
//        productCondition.setProductName("测试");
//        productList = productDao.queryProductList(productCondition,0,3);
//        assertEquals(3,productList.size());
//        count = productDao.queryProductCount(productCondition);
//        assertEquals(9,count);
//    }
//    @Test
//    public void testEupdateProductCategoryToNull(){
//        //将productCategoryId为2的商品类别下面的商品的商品类别置为空
//        int effectedNum = productDao.updateProductCategoryToNull(73L);
//        assertEquals(1,effectedNum);
//    }
//}
