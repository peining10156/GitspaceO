package com.o2o.pn.web.shopadmin;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2o.pn.dto.ShopExecution;
import com.o2o.pn.entity.Area;
import com.o2o.pn.entity.PersonInfo;
import com.o2o.pn.entity.Shop;
import com.o2o.pn.entity.ShopCategory;
import com.o2o.pn.enums.ShopStateEnum;
import com.o2o.pn.service.AreaService;
import com.o2o.pn.service.ShopCategoryService;
import com.o2o.pn.service.ShopService;
import com.o2o.pn.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;
    @Autowired
    ShopCategoryService shopCategoryService;
    @Autowired
    private
    AreaService areaService;
    @RequestMapping(value = "/getshopinitinfo",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getshopinitinfo(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<ShopCategory>shopCategoryList = new ArrayList<ShopCategory>();
        List<Area>areaList = new ArrayList<Area>();
        try {
            shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
            areaList = areaService.getAreaList();
            modelMap.put("shopCategoryList",shopCategoryList);
            modelMap.put("areaList",areaList);
            modelMap.put("success",true);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errorMsg",e.getMessage());
        }
        return modelMap;
    }

@RequestMapping(value = "/registershop",method =RequestMethod.POST)
@ResponseBody
private Map<String ,Object> registershop(HttpServletRequest request){

            Map<String,Object> modelMap= new HashMap<String,Object>();
         //接收并转换相应的阐述，包括店铺信息和图片信息
            String shopStr = HttpServletRequestUtil.getString(request,"shopStr");
            ObjectMapper mapper = new ObjectMapper();
            Shop shop =null;
            try {
                shop = mapper.readValue(shopStr,Shop.class);
            }catch (Exception e){
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
                return  modelMap;
            }
//           HttpServletRequest传过来的文件流转化成Spring能处理的文件流
             CommonsMultipartFile shopImg = null;
             CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                     request.getSession().getServletContext());
              if(commonsMultipartResolver.isMultipart(request)){
                  MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
                  shopImg = (CommonsMultipartFile)multipartHttpServletRequest.getFile("shopImg");
              }else{
                  modelMap.put("success",false);
                  modelMap.put("srrMsg","上传图片文件不能为空");
                  return modelMap;
              }
                //注册店铺
            if (shop !=null&&shopImg !=null){
                PersonInfo owner = new PersonInfo();
                //稍后用session完善
                owner.setUserId(1L);
                shop.setOwner(owner);
                ShopExecution se = null;
                try {
                    se = shopService.addShop(shop,shopImg.getInputStream(),shopImg.getOriginalFilename());
                    if(se.getState()==ShopStateEnum.CHECK.getState()){
                        modelMap.put("success",true);
                        return  modelMap;
                    }else {
                        modelMap.put("success",false);
                        modelMap.put("errMsg",se.getStateInfo());
                    }
                } catch (IOException e) {
                    modelMap.put("success",false);
                    modelMap.put("errMsg",se.getStateInfo());
                }
                return modelMap;

            }else {
                modelMap.put("success",false);
                modelMap.put("srrMsg","请输入店铺信息");
                return modelMap;
            }

    }
}
