package com.o2o.pn.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2o.pn.cache.JedisUtil;
import com.o2o.pn.dao.ShopCategoryDao;
import com.o2o.pn.entity.ShopCategory;
import com.o2o.pn.exceptions.ShopcategoryOperationException;
import com.o2o.pn.service.ShopCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Autowired
    private JedisUtil.Keys jedisKeys;
    @Autowired
    private  JedisUtil.Strings jedisStrings;

    private static Logger logger = LoggerFactory.getLogger(ShopCategoryServiceImpl.class);
    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        //定义redis的key前缀
        String key = SCLISTKEY;
        //定义接收对象
        List<ShopCategory> shopCategoryList = null;
        //定义jackson数据转换操作类
        ObjectMapper mapper = new ObjectMapper();
        //拼接处redis的key
        if (shopCategoryCondition == null){
            //若查询条件为空，则列出所有首页大类，即parentId为空的店铺类别
            key = key +"_allfristlevel";
        }else if (shopCategoryCondition !=null&&shopCategoryCondition.getParent() !=null
                && shopCategoryCondition.getParent().getShopCategoryId() !=null){
            //若parentId为非空，则列出该parentId的所有子类别
            key = key + "_parent" +shopCategoryCondition.getParent().getShopCategoryId();
        }else if (shopCategoryCondition !=null){
            //列出所有子类别，不管起属于哪个类，都列出来
            key = key +"_allsecondlevel";
        }
        //判断key是否存在
        if(!jedisKeys.exists(key)){
            //若不存在，则从 数据库里取出相应的数据
            shopCategoryList = shopCategoryDao.queryShopCategory(shopCategoryCondition);
            //将相关的实体类集合转换成string ,存入redis里的对应key中
            String jsonString;
            try {
                jsonString = mapper.writeValueAsString(shopCategoryList);
            }catch (JsonProcessingException e){
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new ShopcategoryOperationException(e.getMessage());
            }
            jedisStrings.set(key,jsonString);
        }else {
            //若存在，则直接从redis里面取出相应数据
            String jsonString = jedisStrings.get(key);
            //指定要讲string 转换成的集合类型
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class,ShopCategory.class);
            try {
                //将相关key对应的value里的string转换成对象的实体类集合
                shopCategoryList = mapper.readValue(jsonString,javaType);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new ShopcategoryOperationException(e.getMessage());
            }
        }

        return shopCategoryList;
    }
}
