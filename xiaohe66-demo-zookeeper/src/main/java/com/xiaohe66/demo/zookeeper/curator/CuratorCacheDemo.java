package com.xiaohe66.demo.zookeeper.curator;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.springframework.stereotype.Component;

/**
 * @author xiaohe
 * @time 2021.05.19 16:19
 */
@Slf4j
@Component
public class CuratorCacheDemo {

    CuratorFramework curator = CuratorHolder.getNewCurator();

    private String nodePath = "/cache/test1";

    public void test() {

        // 创建一个监听事件，只监听【 /cache 】下的节点（包括他的子节点）
        CuratorCache curatorCache = CuratorCache.build(curator, "/cache");
        curatorCache.listenable().addListener(new CuratorCacheListener() {
            @Override
            public void event(Type type, ChildData oldData, ChildData data) {
                log.info("type : {}, oldData : {}, data) : {}", type.name(), oldData, data);
            }
        });

        curatorCache.start();
    }

    public void addEvent() throws Exception {
        curator.create().creatingParentsIfNeeded().forPath(nodePath, "66".getBytes());
        curator.setData().forPath(nodePath, "77".getBytes());
        curator.delete().deletingChildrenIfNeeded().forPath(nodePath);
    }

}
