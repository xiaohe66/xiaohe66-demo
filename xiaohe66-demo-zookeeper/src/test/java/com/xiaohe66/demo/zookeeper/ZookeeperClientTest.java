package com.xiaohe66.demo.zookeeper;

import com.xiaohe66.demo.zookeeper.test.ZookeeperHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author xiaohe
 * @time 2021.04.30 11:22
 */
@Slf4j
public class ZookeeperClientTest {

    private ZooKeeper zooKeeper = ZookeeperHolder.getZooKeeper();

    @Test
    public void testSyncCreate() throws KeeperException, InterruptedException {

        String ret = zooKeeper.create("/java-node", "test1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.CONTAINER);

        log.info("创建结点，结果 : {}", ret);
    }

    @Test
    public void testAsyncCreate() throws KeeperException, InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        zooKeeper.create("/java-node", "test1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.CONTAINER, (rc, path, ctx, name, stat) -> {
                    log.info("结果, rc : {}, path : {}, ctx : {}, name : {}, stat : {}", rc, path, ctx, name, stat);
                    countDownLatch.countDown();
                },
                "context");

        countDownLatch.await();
    }

    @Test
    public void testGet() throws KeeperException, InterruptedException {

        byte[] data = zooKeeper.getData("/java-node", false, null);
        log.info("getData : {}", new String(data));

    }
}
