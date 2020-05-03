package com.o2o.pn.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/*
*
* 路由分发
* */
@RequestMapping(value = "shopadmin" ,method = {RequestMethod.GET})
public class ShopAdminController {

    @RequestMapping(value = "/shopoperation")

    public String shopOperation(){

        return "/shop/shopoperation";
    }

}
