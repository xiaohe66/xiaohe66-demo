package com.xiaohe66.demo.cloud2.user;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.ribbon.ExtendBalancer;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.IClientConfigAware;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义负载均衡策略
 * 除了实现 IRule, 还需要实现 IClientConfigAware, 不实现会报一个 Warn，还是可以使用的。
 *
 * @author xiaohe
 * @since 2022.02.17 10:11
 */
@Slf4j
public class MyRibbonRule implements IRule, IClientConfigAware {

    private ILoadBalancer loadBalancer;

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Autowired
    private NacosServiceManager nacosServiceManager;

    @Override
    public Server choose(Object key) {

        String group = nacosDiscoveryProperties.getGroup();

        DynamicServerListLoadBalancer loadBalancer = (DynamicServerListLoadBalancer) this.loadBalancer;
        String name = loadBalancer.getName();

        log.info("invoke MyRibbonRule#choose({})", key);

        NamingService namingService = nacosServiceManager.getNamingService(nacosDiscoveryProperties.getNacosProperties());

        // 拿到指定服务在同一组下的健康实例
        try {
            List<Instance> instances = namingService.selectInstances(name, group, true);
            if (instances.isEmpty()) {
                log.warn("no instance in service {}", name);
                return null;
            }

            // 可以对 instances 进行筛选，以达到自定义的目的
            // do sth.

            // 随便取一个，该方法是 nacos 提供的
            Instance instance = ExtendBalancer.getHostByRandomWeight2(instances);

            return new NacosServer(instance);

        } catch (NacosException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.loadBalancer = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.loadBalancer;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        log.debug("MyRibbonRule#initWithNiwsConfig({})",iClientConfig);
    }
}
