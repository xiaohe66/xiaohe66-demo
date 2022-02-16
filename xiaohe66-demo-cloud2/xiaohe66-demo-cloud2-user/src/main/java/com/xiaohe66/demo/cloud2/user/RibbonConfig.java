package com.xiaohe66.demo.cloud2.user;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohe
 * @since 2022.02.17 09:57
 */
@Configuration
public class RibbonConfig {

    // @Bean
    public IRule nacosRule(){
        // 负载均衡策略：同一集群的优先
        // 配置了这个策略后，会优先选择与当前集群相同的集群的服务进行调用
        return new NacosRule();
    }

    @Bean
    public IRule myRule(){
        // 负载均衡策略：同一集群的优先
        // 配置了这个策略后，会优先选择与当前集群相同的集群的服务进行调用
        return new MyRibbonRule();
    }

}
