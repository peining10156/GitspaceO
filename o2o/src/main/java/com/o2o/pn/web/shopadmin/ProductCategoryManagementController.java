package com.o2o.pn.web.shopadmin;


import com.o2o.pn.dto.ProductCategoryExecution;
import com.o2o.pn.dto.Result;
import com.o2o.pn.entity.ProductCategory;
import com.o2o.pn.entity.Shop;
import com.o2o.pn.enums.ProductCategoryStateEnum;
import com.o2o.pn.exceptions.ProductCategoryOperationException;
import com.o2o.pn.service.ProductCategorySercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/shopadmin")
public class ProductCategoryManagementController {
    @Autowired
    private ProductCategorySercive productCategorySercive;

    /*
    *
    * 展示获取商品类别列表
    * */

    @RequestMapping(value="/getproductcategorylist",method = RequestMethod.GET)
    @ResponseBody

    private Result<List<ProductCategory>>getProductCategoryList(HttpServletRequest request){

//
//        Shop shop = new Shop();
//        shop.setShopId(79L);
//        request.getSession().setAttribute("currentShop",shop);

        Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");

        List <ProductCategory> list= null;
        if(currentShop !=null&&currentShop.getShopId()>0){
            list = productCategorySercive.getProductCategoryList(currentShop.getShopId());
            return new Result<List<ProductCategory>>(true,list);

        }
        else {
            ProductCategoryStateEnum ps = ProductCategoryStateEnum.INNER_ERROR;
            return new Result<List<ProductCategory>>(false,ps.getState(),ps.getStateInfo());
        }
    }
    /*
     *
     * 添加商品类别列表
     * */
    @RequestMapping(value = "/addproductcategorys",method = RequestMethod.POST)
    @ResponseBody

        private Map<String,Object>addProductCategorys(@RequestBody List<ProductCategory>productCategoryList,
                                                      HttpServletRequest request){
        Map<String,Object>modelMap = new HashMap<String,Object>();
        Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");

        for (ProductCategory pc:productCategoryList){
            pc.setShopId(currentShop.getShopId());
        }
        if (productCategoryList !=null&&productCategoryList.size()>0){
            try {
                ProductCategoryExecution pe = productCategorySercive.batchAddProductCategory(productCategoryList);
                if (pe.getState()== ProductCategoryStateEnum.SUCCESS.getState()){
                    modelMap.put("successs",true);
                }else{
                    modelMap.put("success",false);
                    modelMap.put("errMsg",pe.getStateInfo());
                }
            }catch (ProductCategoryOperationException e){
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
                return modelMap;
            }
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","请输入至少一个商品类别");
        }
        return modelMap;
    }
    /*
    * 删除商品类别
    * */
    @RequestMapping(value = "/removeproductcategory",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object>removeProductCategory(Long productCategoryId,HttpServletRequest request){

        Map<String,Object>modelMap = new HashMap<String,Object>();
        if(productCategoryId != null && productCategoryId >0){
            try {
                Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
                ProductCategoryExecution PE =productCategorySercive.deleteProductGory(productCategoryId,currentShop.getShopId());
                if (PE.getState()== ProductCategoryStateEnum.SUCCESS.getState()){
                    modelMap.put("success",true);
                }else {
                    modelMap.put("success",false);
                    modelMap.put("errMsg",PE.getStateInfo());
                }
            }catch (ProductCategoryOperationException e){
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
                return modelMap;
            }

        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","请输入至少一个商品类别");
        }
        return modelMap;
    }

}
