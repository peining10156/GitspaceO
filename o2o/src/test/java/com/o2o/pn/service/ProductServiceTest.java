//package com.o2o.pn.service;
//
//import com.o2o.pn.BaseTest;
//import com.o2o.pn.dto.ImageHolder;
//import com.o2o.pn.dto.ProductExecution;
//import com.o2o.pn.entity.Product;
//import com.o2o.pn.entity.ProductCategory;
//import com.o2o.pn.entity.Shop;
//import com.o2o.pn.enums.ProductStateEnum;
//import com.o2o.pn.exceptions.ShopOperationException;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class ProductServiceTest extends BaseTest {
//
//        @Autowired
//        private ProductService productService;
//        @Test
//    public void testAddProduct()throws ShopOperationException,FileNotFoundException{
//
//            //创建shopID为79且productCategoryId为52的的商品实例并给起成员变量赋值
//            Product product = new Product();
//            Shop shop =new Shop();
//            shop.setShopId(79L);
//            ProductCategory PC = new ProductCategory();
//            PC.setProductCategoryId(52L);
//            product.setShop(shop);
//
//            product.setProductCategory(PC);
//            product.setProductName("测试商品1");
//            product.setProductDesc("测试1");
//            product.setPriority(22);
//            product.setCreateTime(new Date());
//            product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
//            //创建缩略图文件流
//            File thunbanailFile = new File("D:/image/baoerjie.jpg");
//            InputStream is =new FileInputStream(thunbanailFile);
//            ImageHolder thumbnail = new ImageHolder(is,thunbanailFile.getName());
//            //创建两个商品详情图文件流并将他们添加的到详情图列表中
//            File productImg1= new File("D:/image/baoerjie.jpg");
//            InputStream is1 = new FileInputStream(productImg1);
//            File productImg2= new File("D:/image/zhangchulan.jpg");
//            InputStream is2 = new FileInputStream(productImg2);
//            List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
//            productImgList.add(new ImageHolder(is1,productImg1.getName()));
//            productImgList.add(new ImageHolder(is2,productImg2.getName()));
//            //添加商品并验证
//            ProductExecution pe = productService.addProduct(product,thumbnail,productImgList);
//            assertEquals(ProductStateEnum.SUCCESS.getState(),pe.getState());
//
//        }
//
//        @Test
//        public void testBModifyProduct()throws ShopOperationException,FileNotFoundException{
//                //创建shopID为79且productCategoryId为52的商品实例并给其成员变量赋值
//                Product product = new Product();
//                Shop shop =new Shop();
//                shop.setShopId(79L);
//                ProductCategory PC = new ProductCategory();
//                PC.setProductCategoryId(52L);
//                product.setProductId(1L);
//                product.setShop(shop);
//                product.setProductCategory(PC);
//                product.setProductName("正式商品1");
//                product.setProductDesc("正式商品2");
//                product.setPriority(33);
//                product.setCreateTime(new Date());
//                product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
//                //创建缩略图文件流
//                File thunbanailFile = new File("D:/image/baoerjie.jpg");
//                InputStream is =new FileInputStream(thunbanailFile);
//                ImageHolder thumbnail = new ImageHolder(is,thunbanailFile.getName());
//                //创建两个商品详情图文件流并将他们添加的到详情图列表中
//                File productImg1= new File("D:/image/baoerjie.jpg");
//                InputStream is1 = new FileInputStream(productImg1);
//                File productImg2= new File("D:/image/zhangchulan.jpg");
//                InputStream is2 = new FileInputStream(productImg2);
//                List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
//                productImgList.add(new ImageHolder(is1,productImg1.getName()));
//                productImgList.add(new ImageHolder(is2,productImg2.getName()));
//                //添加商品并验证
//                ProductExecution pe = productService.modifyProduct(product,thumbnail,productImgList);
//                assertEquals(ProductStateEnum.SUCCESS.getState(),pe.getState());
//
//
//        }
//}
//
//
//
//
