package com.xiaohe66.demo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 每个服务 都需要加上 <code> @EnableDiscoveryClient </code> 注解
 *
 * @author xiaohe
 * @date 2019.03.05 18:10
 */
@EnableDiscoveryClient
@SpringBootApplication
public class XhDemoOrder8100Application {

    public static void main(String[] args) {
        SpringApplication.run(XhDemoOrder8100Application.class, args);
    }

}
