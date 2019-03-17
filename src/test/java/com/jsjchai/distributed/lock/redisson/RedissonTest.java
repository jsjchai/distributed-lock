package com.jsjchai.distributed.lock.redisson;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;

/**
 * @author jsjchai.
 */
public class RedissonTest {

    /**
     * 只能在linux下运行
     */
    @Test
    public void create() {
        Config config = new Config();
        config.setTransportMode(TransportMode.EPOLL);

        /** 可以用"rediss://"来启用SSL连接 */
        config.useClusterServers().addNodeAddress("redis://127.0.0.1:6391");

        RedissonClient redissonClient = Redisson.create(config);

        RBucket<String> rBucket = redissonClient.getBucket("test");
        rBucket.set("123456");


    }
}
