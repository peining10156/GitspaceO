package com.o2o.pn.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.util.SafeEncoder;
import java.util.Set;
public class JedisUtil {

    /** 操作KEY的方法**/
    public Keys KEYS;
    /**对储存结构为String类型的操作**/
    public Strings STRINGS;
    /**redis连接池对象**/
    private JedisPool jedisPool;

    /** 获取redis链接池**/
    public JedisPool getJedisPool() {
        return jedisPool;
    }
    /**设置redis链接池**/
    public void setJedisPool(JedisPoolWriper jedisPoolWriper) {
        this.jedisPool = jedisPoolWriper.getJedisPool();
    }
    /**从jedis连接池中获取jdeis对象**/
    public Jedis getJedis(){
        return jedisPool.getResource();
    }
    /*************************************Keys**********************************/
    public class Keys{

        public Keys(JedisUtil jedisUtil) {
        }

        /*
        * 清空有所key
        * */
        public String flushAll(){

           Jedis jedis = getJedis();
           String stata = jedis.flushAll();
                jedis.close();
                return stata;
            }
        /*
         * 删除keys对应的记录，可以是多个key
         * @param String
         *       ...keys
         *   @return 删除的记录数
         * */
        public long del(String... keys){

            Jedis jedis = getJedis();
            long count =jedis.del(keys);
            jedis.close();
            return count;
        }
        /*判断key是否存在
         *
         * @param string
         *           key
         * @return boolean
         **/
        public boolean exists(String key){
            //ShardedJeddis sjedis = getShardedJedis();
            Jedis sjedis = getJedis();
            boolean exis = sjedis.exists(key);
            sjedis.close();
            return exis;

        }
        /*
        * 查找所有匹配给定的模式的键
        *   key的表达式，*表示多少个，？表示一个
        * */
        public Set<String> keys(String pattern){
            Jedis jedis = getJedis();
            Set<String> set = jedis.keys(pattern);
            jedis.close();
            return set;
        }
    }
    /******************************************Strings*****************************************/
    public class Strings{
        public Strings(JedisUtil jedisUtil) {
        }

        /*
        * 根据Key获取记录
        * @param String
        *           key
        * @return 值
        * */
        public String get(String key){
            Jedis sjedis = getJedis();
            String value = sjedis.get(key);
            sjedis.close();
            return value;
        }
        /*
        * 添加记录，如果记录已存在将覆盖原有的value
        * @param String
        *   key
        *  @param String
        *   value
        *   @return 状态码
        * */
        public String set(String key,String value){
            return set(SafeEncoder.encode(key),SafeEncoder.encode(value));
        }
        /*
        * 添加记录，如果记录存在将覆盖原有的value
        * @param byte[] key
        * @param byte[] value
        * return 状态码
        * */
        private String set(byte[] key, byte[] value) {
            Jedis jedis = getJedis();
            String status = jedis.set(key,value);
            jedis.close();
            return status;
        }

    }

}
