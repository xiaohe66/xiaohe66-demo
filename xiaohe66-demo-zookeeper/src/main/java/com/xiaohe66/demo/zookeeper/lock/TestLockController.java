package com.xiaohe66.demo.zookeeper.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaohe
 * @time 2021.05.27 17:22
 */
@RequestMapping("/lock")
@RestController
public class TestLockController {

    private final CuratorFramework curatorFramework;
    private final OrderService orderService;

    AtomicInteger count = new AtomicInteger();

    /**
     * 启动时添加JVM参数：  -Dserver.port=8080
     */
    @Value("${server.port}")
    private String port;

    public TestLockController(CuratorFramework curatorFramework, OrderService orderService) {
        this.curatorFramework = curatorFramework;
        this.orderService = orderService;
    }

    @PostMapping("/orderLock")
    public String order() throws Exception {

        //return String.valueOf(count.getAndIncrement());

        //return order1();
        return order2();
    }

    /* 普通方式  */
    public String order1() throws Exception {
        orderService.addOrder(1);
        return "ok:" + port;
    }

    /* 分布式锁方式 */
    public String order2() throws Exception {

        int productId = 1;

        // 分布式锁
        InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework, "/product_" + productId);
        try {
            interProcessMutex.acquire();
            orderService.addOrder(productId);

        } catch (Exception e) {
            throw new RuntimeException(e);

        } finally {
            interProcessMutex.release();
        }

        return "ok:" + port;
    }

}
