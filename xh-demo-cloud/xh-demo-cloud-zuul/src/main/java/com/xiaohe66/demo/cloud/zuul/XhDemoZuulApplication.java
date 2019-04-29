package com.xiaohe66.demo.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 每个服务 都需要加上 <code> @EnableDiscoveryClient </code> 注解
 *
 * @author xiaohe
 * @date 2019.03.05 18:10
 */
@EnableZuulProxy
@SpringBootApplication
public class XhDemoZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(XhDemoZuulApplication.class, args);
    }

}
