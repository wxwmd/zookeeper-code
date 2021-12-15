package com.ms.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class Monitor {
    String hostURL="127.0.0.1:2181";
    int connectionTimeout=3000;

    ZooKeeper zkClient=new ZooKeeper(hostURL, connectionTimeout, new Watcher() {
        public void process(WatchedEvent event) {
            try {
                // zk设置监听之后例可失效，必须在时间发生之后再次设置监听
                // 此处设置的是监听根目录
                List<String> children = zkClient.getChildren("/", true);
                System.out.println("----------------------------");
                children.forEach(System.out::println);
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    public Monitor() throws IOException {
    }

    @Test
    public void Listen() throws InterruptedException {
        System.out.println("begin");
        // 线程阻塞，持续监听
        Thread.sleep(Long.parseLong("10000000"));
    }
}
