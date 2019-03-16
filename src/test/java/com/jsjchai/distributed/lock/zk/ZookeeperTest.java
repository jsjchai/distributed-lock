package com.jsjchai.distributed.lock.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
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

    @Test
    public void create(){
        try {
            ZooKeeper client = new ZooKeeper("127.0.0.1:2181",  10000,null);
            String path = "/test";
            Stat stat = client.exists(path,null);
            if(stat != null){
                log.info(path+"is exists");
                return;
            }
            client.create(path,"test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            log.info(path +" create success");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } catch (KeeperException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getData(){
        try {
            ZooKeeper client = new ZooKeeper("127.0.0.1:2181",  10000,null);
            String path = "/test";

            log.info("client get data:{}",new String(client.getData(path,null,null)));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } catch (KeeperException | IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void del(){
        try {
            ZooKeeper client = new ZooKeeper("127.0.0.1:2181",  10000,null);
            String path = "/test";
            client.delete(path,0);
            log.info("client del success");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } catch (KeeperException | IOException e) {
            e.printStackTrace();
        }
    }


}
