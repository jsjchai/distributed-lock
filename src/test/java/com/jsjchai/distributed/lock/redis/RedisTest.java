package com.jsjchai.distributed.lock.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jsjchai.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {


    @Autowired
    private  RedisTemplate<String, String> redisTemplate;

    @Before
    public void before(){
        CacheProvider.init(redisTemplate);
    }

    @Test
    public void testRedisTemplate(){
        log.info("redisTemplate:{}",redisTemplate);
    }

    @Test
    public void testSet(){
        CacheProvider.set("k1","123456",100L);
    }
}
