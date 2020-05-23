package com.o2o.pn.service;

public interface CacheService {

    /*
    * 依据key前缀删除匹配该模式下的所有key-value 如吹安茹：shopcategory,则shopcategory_allfirstLevel等
    * 已shopcategory打头的key_value都会被清空
    *@param keyPrefix
    * @return
    * */
    void removeFromCache(String keyPrefix);
}
