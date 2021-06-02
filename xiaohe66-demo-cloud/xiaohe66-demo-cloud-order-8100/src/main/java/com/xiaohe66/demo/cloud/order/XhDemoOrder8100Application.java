package com.xiaohe66.demo.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 每个服务 都需要加上 <code> @EnableDiscoveryClient </code> 注解
 *
 * @author xiaohe
 * @date 2019.03.05 18:10
 */
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients("com.xiaohe66.demo.cloud")
@EnableHystrixDashboard
@SpringBootApplication
public class XhDemoOrder8100Application {

    public static void main(String[] args) {
        SpringApplication.run(XhDemoOrder8100Application.class, args);
    }

}
