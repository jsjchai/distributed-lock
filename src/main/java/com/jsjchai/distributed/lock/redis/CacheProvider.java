package com.jsjchai.distributed.lock.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author jsjchai.
 */
public class CacheProvider {


    private static RedisTemplate<String, String> template;

    public static void init(RedisTemplate<String, String> template){
        CacheProvider.template =  template;
    }

    public static <T> boolean set(String key, T value) {
        return set(key, JSON.toJSONString(value),-1L);
    }

    public static boolean set(String key, String value, long validTime) {

        return template.execute(new RedisCallback<Boolean>() {

            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = template.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                connection.expire(serializer.serialize(key), validTime);
                return true;
            }
        });
    }

    public static <T> T get(String key, Class<T> clazz) {
        return JSON.parseObject(get(key), clazz);
    }

    public static String get(String key) {
        return template.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = template.getStringSerializer();
                byte[] value = connection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });
    }

    public static boolean del(String key) {
        return template.delete(key);
    }

}
