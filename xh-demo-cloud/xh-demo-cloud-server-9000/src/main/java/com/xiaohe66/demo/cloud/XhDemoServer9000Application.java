package com.xiaohe66.demo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 公共服务端需要加上 <code> @EnableEurekaServer </code> 注解
 *
 * @author xiaohe
 * @date 2019.03.05 18:10
 */
@EnableEurekaServer
@SpringBootApplication
public class XhDemoServer9000Application {

    public static void main(String[] args) {
        SpringApplication.run(XhDemoServer9000Application.class, args);
    }

}
