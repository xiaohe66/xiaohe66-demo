package com.xiaohe66.demo.cloud2.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author xiaohe
 * @since 2022.02.09 15:25
 */
@SpringBootApplication
@EnableFeignClients // 该注解用于开启 feign 客户端
// @EnableDiscoveryClient // 开启nacos客户端，实际上不加该注解也是可以的
public class Cloud2UserApplication {

    /**
     *  TODO : 到底是 spring cloud 提供的 @LoadBalanced 还是ribbon提供的
     * {@link LoadBalanced} 注解：
     * 添加该注解后，可以获得自动替换请求地址的能力（?的能力），不添加则无法自动替换
     * 该注解是通过调用 {@link RestTemplate#setInterceptors(List)}方法实现自动替换请求地址的
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {

        SpringApplication.run(Cloud2UserApplication.class, args);
    }
}
