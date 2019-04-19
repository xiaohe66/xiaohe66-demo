package com.xiaohe66.demo.cloud.cfg;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * 自定义随机 rule
 *
 * @author xiaohe
 * @date 2019.04.19 15:50
 */
public class XhRule extends AbstractLoadBalancerRule {

    private Random random;

    public XhRule(){
        random = new Random();
    }


    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
       ILoadBalancer loadBalancer =  getLoadBalancer();

       List<Server> list =  loadBalancer.getReachableServers();


        return list.get(random.nextInt(list.size()));

    }
}
