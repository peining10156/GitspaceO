package com.o2o.pn.web.frontend;


import com.o2o.pn.entity.Product;
import com.o2o.pn.service.ProductService;
import com.o2o.pn.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/frontend")
/*
* 商品详情图展示
* */

public class ProductDetailController {

    @Autowired
    private ProductService productService;
    @RequestMapping(value = "/listproductdetailpageinfo",method = RequestMethod.GET)
    @ResponseBody
    /*
    * 根据商品Id获取商品详情
    * */
    private Map<String,Object>listProductDetailPageInfo(HttpServletRequest request){
        Map<String,Object>modelMap = new HashMap<String, Object>();

        long productId = HttpServletRequestUtil.getLong(request,"productId");
        Product product = null;
        //判断productId是否为空
        if (productId !=-1){
            //根据商品productId查询商品信息
            product = productService.getProductById(productId);
            modelMap.put("product",product);
            modelMap.put("success",true);
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","empty productId");
        }
        return modelMap;
    }
}
