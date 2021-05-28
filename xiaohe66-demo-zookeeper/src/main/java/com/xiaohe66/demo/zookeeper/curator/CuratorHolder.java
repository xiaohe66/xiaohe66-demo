package com.xiaohe66.demo.zookeeper.curator;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author xiaohe
 * @time 2021.05.19 14:52
 */
@Slf4j
public class CuratorHolder {

    // 重试策略
    private static RetryPolicy retryPolicy;

    private static final String connectionString = "192.168.181.128:2181";

    private static CuratorFramework curator;

    static {
        /*
          重试策略
          RetryPolicy的子类 :
          ExponentialBackoffRetry.class    重试一组次数，重试之间的睡眠时间增加
          RetryNTimes.class                重试最大次数
          RetryOneTime.class               只重试一次
          RetryUntilElapsed.class          在给定的时间结束之前重试
         */
        retryPolicy = new ExponentialBackoffRetry(1000, 3);
        curator = createByFactory();
    }

    private CuratorHolder() {

    }


    public static CuratorFramework createByFactory() {
        CuratorFramework curator = CuratorFrameworkFactory.newClient(connectionString, retryPolicy);
        // 方法是异步的
        curator.start();
        log.info("创建成功");
        return curator;
    }

    public static CuratorFramework createByBuilder() {
        CuratorFramework curator = CuratorFrameworkFactory.builder()
                .connectString(connectionString)
                .retryPolicy(retryPolicy)
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(5000)
                .namespace("myCurator")
                .build();
        curator.start();
        log.info("创建成功");
        return curator;
    }

    public static CuratorFramework getCurator() {
        return curator;
    }

    public static CuratorFramework getNewCurator() {
        return createByFactory();
    }
}
