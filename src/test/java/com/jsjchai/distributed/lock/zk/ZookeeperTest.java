package com.jsjchai.distributed.lock.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author jsjchai.
 */
@Slf4j
public class ZookeeperTest {

    @Test
    public void testConnection(){
        try {
            ZooKeeper client = new ZooKeeper("127.0.0.1:2181",  10000,null);
            log.info("state:{}",client.getState().toString());
            //client.create("/test",null, ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            List<String> childs =  client.getChildren("/",null);
            if(childs == null || childs.isEmpty()){
                log.info("childs is null");
                return;
            }
            log.info("size:{}",childs.size());
            childs.forEach(log::info);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } catch (KeeperException | IOException e) {
            e.printStackTrace();
        }
    }
}
