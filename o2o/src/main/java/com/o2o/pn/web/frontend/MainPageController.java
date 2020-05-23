package com.o2o.pn.web.frontend;


import com.o2o.pn.entity.HeadLine;
import com.o2o.pn.entity.ShopCategory;
import com.o2o.pn.service.HeadLineService;
import com.o2o.pn.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/frontend")
/*
* 前端展示系统
* */
public class MainPageController {

        @Autowired
    private ShopCategoryService shopCategoryService;
        @Autowired
    private HeadLineService headLineService;

/*
* 初始化前端展示系统的主页信息，包括获取一级店铺类别列表以及头条列表
* @return
* */
@RequestMapping(value = "/listmainpageinfo",method = RequestMethod.GET)
@ResponseBody
    private Map<String,Object> ListMainPageInfo(){
        Map<String,Object>modelMap = new HashMap<String, Object>();
        List<ShopCategory> shopCategorylist = new ArrayList<ShopCategory>();
        try {
            //获取一级店铺类别列表（即parent_id为空的shopCategory）
            shopCategorylist = shopCategoryService.getShopCategoryList(null);
            modelMap.put("shopCategoryList",shopCategorylist);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
            return modelMap;
        }
        List<HeadLine>headLineList =new ArrayList<HeadLine>();
        try {
            //获取状态为可用（1）的头条列表
            HeadLine headLineCondition = new HeadLine();
            headLineCondition.setEnableStatus(1);
            headLineList= headLineService.getHeadLineList(headLineCondition);
            modelMap.put("headLineList",headLineList);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
            return modelMap;
        }
        modelMap.put("success",true);
    return modelMap;
}


}
