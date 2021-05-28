package com.xiaohe66.demo.zookeeper.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author xiaohe
 * @time 2021.05.14 15:27
 */
@Slf4j
public class ZookeeperHolder {

    private static final int SESSION_TIME_OUT = 5000;

    /**
     * zookeeper 的地址，为ip+端口的形式，并以逗号隔开以表示多个地址。示例：ip:port,ip:port
     */
    private static final String address = "192.168.181.128:2181";

    private static ZooKeeper zooKeeper;

    private static void newZk() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            if (zooKeeper != null) {
                zooKeeper.close();
            }
            zooKeeper = new ZooKeeper(address, SESSION_TIME_OUT, event -> {

                if (event.getState() == Watcher.Event.KeeperState.SyncConnected
                        && event.getType() == Watcher.Event.EventType.None) {

                    log.info("连接成功");
                    countDownLatch.countDown();
                }
            });
            log.info("连接中...");
            countDownLatch.await();

        } catch (InterruptedException | IOException e) {
            log.error(e.getMessage(), e);
            Thread.currentThread().interrupt();
        }
    }

    public static ZooKeeper getZooKeeper() {
        if (zooKeeper == null || zooKeeper.getState() == ZooKeeper.States.NOT_CONNECTED) {
            newZk();
        }
        return zooKeeper;
    }
}
