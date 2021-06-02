package com.xiaohe66.demo.cloud.user;

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
public class XhDemoUser8000Application {

    public static void main(String[] args) {
        SpringApplication.run(XhDemoUser8000Application.class, args);
    }

}
