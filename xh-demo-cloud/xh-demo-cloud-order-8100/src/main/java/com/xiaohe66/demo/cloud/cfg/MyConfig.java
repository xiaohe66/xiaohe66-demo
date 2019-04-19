package com.xiaohe66.demo.cloud.cfg;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaohe
 * @date 2019.04.17 20:41
 */
@Configuration
public class MyConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 修改 RestTemplate 调用服务的轮询器
     */
//    @Bean
    public IRule myRule(){
        return new XhRule();
    }

}
