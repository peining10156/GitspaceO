package com.o2o.pn.web.frontend;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/frontend")
public class FrontendController {
    /*
    * 前端首页路由
    *
    * */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    private String index(){
        return "/frontend/index";
    }
    @RequestMapping(value = "/shoplist",method = RequestMethod.GET)
    private String shopList(){
        return "/frontend/shoplist";
    }
    /*
    *
    * 店铺详情页路由
    * */
    @RequestMapping(value = "/shopdetail",method = RequestMethod.GET)
    private String shopDetail(){return "/frontend/shopdetail";}
    /*
    * 商品详情页路由
    *
    * */
    @RequestMapping(value = "/productdetail",method = RequestMethod.GET)
    private String productDetail(){return "/frontend/productdetail";}

}
