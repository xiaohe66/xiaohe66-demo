package com.xiaohe66.demo.zookeeper;

import com.xiaohe66.demo.zookeeper.curator.CuratorCacheDemo;
import com.xiaohe66.demo.zookeeper.curator.CuratorDemo;
import com.xiaohe66.demo.zookeeper.curator.CuratorListenerDemo;
import com.xiaohe66.demo.zookeeper.test.ZookeeperDemo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author xiaohe
 * @time 2021.05.14 15:13
 */
@RestController
@RequestMapping("/zk")
@AllArgsConstructor
@Slf4j
public class TestController {

    ZookeeperDemo demo;
    CuratorDemo curatorDemo;
    CuratorListenerDemo listenerDemo;
    CuratorCacheDemo cacheDemo;

    @PostMapping("/test")
    public String test() throws Exception {

        //curatorDemo.createByFactory();
        //curatorDemo.testGetDataAsync2();

        //listenerDemo.test();
        cacheDemo.addEvent();

        return LocalDateTime.now().toString();
    }
}
