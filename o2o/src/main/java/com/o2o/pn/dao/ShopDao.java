package com.o2o.pn.dao;

import com.o2o.pn.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {

    /*
    *
    * 分页查询店铺 可输入的条件有；店铺名（模糊），店铺状态（），店铺类别（），区域ID，owner
    * @Param("shopCondition")查询的条件
    * @Param("rowIndex")从第几行开始取
    * @Param("pageSize")返回的条数
    * */

    List<Shop>queryShopList(@Param("shopCondition")Shop shopCondition,@Param("rowIndex") int rowIndex,@Param("pageSize")int pageSize);

    /*
    *
    * 返回queryShopList总数
    * */
    int queryShopCount(@Param("shopCondition")Shop shopCondition);
    /*
    *通过shopId查询店铺
    * 返回店铺ID
    * */
    Shop queryByShopId(Long shopId);
    /*
    * 新增店铺
    *
    * */
    int insertShop(Shop shop);

    /*
    * 更新店铺信息
    *
    * */
    int updateShop(Shop shop);

}
