package org.liujiazhen.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

public class ConnectionDemo {
    public static void main(String[] args) {
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ZooKeeper zooKeeper = new ZooKeeper("192.168.0.33:2181", 4000, event -> {
                if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
                    // 如果收到了服务端的响应事件，连接成功
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            // CONNECTED
            zooKeeper.create("/runoob", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(zooKeeper.getState());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
