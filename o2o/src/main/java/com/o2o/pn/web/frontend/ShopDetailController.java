package com.o2o.pn.web.frontend;

import com.o2o.pn.dto.ProductExecution;
import com.o2o.pn.entity.Product;
import com.o2o.pn.entity.ProductCategory;
import com.o2o.pn.entity.Shop;
import com.o2o.pn.service.ProductCategorySercive;
import com.o2o.pn.service.ProductService;
import com.o2o.pn.service.ShopService;
import com.o2o.pn.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/frontend")
public class ShopDetailController {

/*
* 店铺详情页展示
* */
    @Autowired
    private ShopService shopService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategorySercive productCategorySercive;

    /*
    *获取店铺信息以及该店铺下面的商品类别列表
    *
    * */
    @RequestMapping(value = "/listshopdetailpageinfo",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object>listShopDetailPageInfo(HttpServletRequest request){
        Map<String,Object>modelMap = new HashMap<String, Object>();

        //从前台获取传过来的ShopId
        long shopId = HttpServletRequestUtil.getLong(request,"shopId");
        Shop shop = null;
        List<ProductCategory>productCategoryList = null;
        if(shopId !=-1){
            //获取店铺ID为shopID的店铺信息
            shop = shopService.shopByShopId(shopId);
            //获取店铺下面的商品类别列表
            productCategoryList = productCategorySercive.getProductCategoryList(shopId);
            modelMap.put("shop",shop);
            modelMap.put("productCategoryList",productCategoryList);
            modelMap.put("success",true);
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","empty shopId");
        }
        return modelMap;
    }
    /*
    *依据查询条件分页列出该店铺下面的所有商品
    *@param request
    * @return
    *
    * */
    @RequestMapping(value = "/listproductsbyshop",method =RequestMethod.GET )
    @ResponseBody
    private Map<String,Object>listProductsByShop(HttpServletRequest request){
        Map<String,Object>modelMap = new HashMap<String, Object>();

        //获取前台传过来的页码
        int pageIndex = HttpServletRequestUtil.getInt(request,"pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request,"pageSize");
        long shopId= HttpServletRequestUtil.getLong(request,"shopId");
        //空值判断
        if((pageIndex > -1)&&(pageSize >-1)&&(shopId >-1)){
            //尝试获取商品类别ID
            long productCategoryId = HttpServletRequestUtil.getLong(request,"productCategoryId");
            //尝试获取模糊查找的商品名
            String productName = HttpServletRequestUtil.getString(request,"productName");
            //组合查询条件
            Product productCondition = compactProductCondition4Search(shopId,productCategoryId,productName);
            //按照传入的查询条件以及枫叶信息返回相应商品列表以及总数，
            ProductExecution pe = productService.getProductList(productCondition,pageIndex,pageSize);
            modelMap.put("productList",pe.getProductList());
            modelMap.put("count",pe.getCount());
            modelMap.put("success",true);

        }else {
            modelMap.put("success",false);
            modelMap.put("errNsg","empty pageSize or pageIndex or shopId");
        }

        return modelMap;
    }
        /*
        * 组合查询条件，并将条件封装到productCondition对象里返回
        * @param shopId
        * @param productCategoryId
        *@param  productName
        * */
    private Product compactProductCondition4Search(long shopId, long productCategoryId, String productName) {

        Product productCondition = new Product();
        Shop shop = new Shop();
        shop.setShopId(shopId);
        productCondition.setShop(shop);
        if (productCategoryId != -1L){
            //查询某个商品类别下面的商品列表
            ProductCategory productCategory = new ProductCategory();
            productCategory.setProductCategoryId(productCategoryId);
            productCondition.setProductCategory(productCategory);
        }
        if (productName != null){
            //查询名字里包含的productName的店铺列表
            productCondition.setProductName(productName);
        }
        //只允许选出状态为上架的商品
        productCondition.setEnableStatus(1);
        return productCondition;
    }

}
