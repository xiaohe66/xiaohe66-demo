package com.xiaohe66.demo.zookeeper.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * @author xiaohe
 * @time 2021.05.14 17:03
 */
@Slf4j
@Component
public class ZookeeperDemo {

    private ZooKeeper zooKeeper;

    private String nodeName = "/java-node";

    public void newZk() {
        zooKeeper = ZookeeperHolder.getZooKeeper();
    }

    public void testSyncCreate() throws KeeperException, InterruptedException {

        String ret = zooKeeper.create(nodeName, "test1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.CONTAINER);

        log.info("创建结点，结果 : {}", ret);
    }

    public void testAsyncCreate() throws KeeperException, InterruptedException {

        zooKeeper.create(nodeName, "test1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.CONTAINER, (rc, path, ctx, name, stat) -> {
                    log.info("异步创建结果, rc : {}, path : {}, ctx : {}, name : {}, stat : {}", rc, path, ctx, name, stat);
                },
                "context");

        log.info("异步创建");
    }

    public void testGet() throws KeeperException, InterruptedException {
        byte[] data = zooKeeper.getData(nodeName, false, null);
        log.info("getData : {}", new String(data));
    }

    public void testEachGet() throws KeeperException, InterruptedException {
        Watcher watch = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getType() == Watcher.Event.EventType.NodeDataChanged) {
                    try {
                        // 传进去的 stat 会接收 节点的 stat数据
                        Stat stat = new Stat();
                        byte[] data = ZookeeperHolder.getZooKeeper().getData(nodeName, this, stat);
                        log.info("数据被改变 : {}, version : {}", new String(data), stat.getVersion());

                    } catch (KeeperException | InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };
        byte[] data = ZookeeperHolder.getZooKeeper().getData(nodeName, watch, null);
        log.info("初始数据 : {}", new String(data));
    }

    public void testSet() throws KeeperException, InterruptedException {
        String newData = LocalTime.now().toString();
        ZookeeperHolder.getZooKeeper().setData(nodeName, newData.getBytes(), 14);

        log.info("修改成功");
    }

    public void testDel() throws KeeperException, InterruptedException {

        ZookeeperHolder.getZooKeeper().delete(nodeName, 15);

        log.info("删除成功");

    }
}
