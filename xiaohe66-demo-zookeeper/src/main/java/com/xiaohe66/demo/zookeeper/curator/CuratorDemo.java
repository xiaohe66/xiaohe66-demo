package com.xiaohe66.demo.zookeeper.curator;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiaohe
 * @time 2021.05.17 11:29
 */
@Component
@Slf4j
public class CuratorDemo {

    /**
     * CuratorFramework 相当与一个 zookeeper 客户端
     */
    private CuratorFramework curator = CuratorHolder.getCurator();

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();


    public void testCreate() throws Exception {
        String ret = curator.create().forPath("/curator", "test".getBytes());
        outRet(ret);
    }

    public void testCreateType() throws Exception {
        // 指定节点类型
        String ret = curator.create().withMode(CreateMode.CONTAINER).forPath("/curator", "test2".getBytes());
        outRet(ret);
    }

    public void testCreateIfNeed() throws Exception {
        // 指定节点类型
        String ret = curator.create().creatingParentsIfNeeded().forPath("/curator/sub-1", "test2".getBytes());
        outRet(ret);
    }

    public void testGetData() throws Exception {
        byte[] bytes = curator.getData().forPath("/curator/sub-1");
        outRet(new String(bytes));
    }

    public void testGetDataAsync() throws Exception {
        // 异步，在EventThread中执行
        curator.getData().inBackground((curatorFramework, curatorEvent) -> {

            log.info("getData异步结果, path : {},data : {}", curatorEvent.getPath(), new String(curatorEvent.getData()));

        }).forPath("/curator");

        // 异步取数的结果为 null
        //outRet(new String(bytes));
    }

    public void testGetDataAsync2() throws Exception {
        // 可以自定义线程池，inBackground方法的第2个参数就是
        curator.getData().inBackground((curatorFramework, curatorEvent) -> {

            log.info("getData异步结果, path : {},data : {}", curatorEvent.getPath(), new String(curatorEvent.getData()));

        }, executorService).forPath("/curator");
    }

    public void testSetData() throws Exception {

        Stat stat = curator.setData().forPath("/curator", "newData".getBytes());
        log.info("设置数据, stat : {}", stat);
    }

    public void testDelete() throws Exception {
        // 只能删除单个节点，存在子节点时不存删除
        curator.delete().forPath("/curator");
        outRet("ok");
    }

    public void testDeleteIfNeed() throws Exception {
        curator.delete().deletingChildrenIfNeeded().forPath("/curator");
        outRet("ok");
    }

    private void outRet(String ret) {
        log.info("结果 : {}", ret);
    }
}
