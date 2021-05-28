package com.xiaohe66.demo.zookeeper.curator;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.stereotype.Component;

/**
 * @author xiaohe
 * @time 2021.05.19 14:51
 */
@Component
@Slf4j
public class CuratorListenerDemo {

    CuratorFramework curator = CuratorHolder.getNewCurator();

    private String nodePath = "/listener/test";

    public void test() throws Exception {

        curator.getCuratorListenable().addListener((curatorFramework, curatorEvent) ->
                log.info("listener事件, type : {}, event : {}", curatorEvent.getType().name(), curatorEvent)
        );

        curator.create().creatingParentsIfNeeded().forPath(nodePath, "init".getBytes());
        curator.setData().inBackground().forPath(nodePath, "666".getBytes());
        curator.setData().inBackground().forPath(nodePath, "777".getBytes());
    }

}
