package com.ms.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Connection {
    String connectionURL="127.0.0.1:2181";
    int sessionTimeout=2000;
    ZooKeeper zooKeeper = new ZooKeeper(connectionURL, sessionTimeout, new Watcher() {
        public void process(WatchedEvent event) {

        }
    });

    public Connection() throws IOException {
    }

    @Test
    /*
    * 检查连接是否正常
    * */
    void TestConnection() throws InterruptedException, KeeperException {
        System.out.println(zooKeeper.getAllChildrenNumber("/"));
    }

    @Test
    /*
    * 创建节点
    * */
    void TestCreate() throws InterruptedException, KeeperException {
        String res = zooKeeper.create("/ms", "suzhou ms".getBytes(), ZooDefs.Ids.READ_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(res);
    }
}
