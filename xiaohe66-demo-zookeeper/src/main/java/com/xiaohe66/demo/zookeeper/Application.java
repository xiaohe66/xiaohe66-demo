package com.xiaohe66.demo.zookeeper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaohe
 * @time 2021.05.14 15:09
 */
@MapperScan("com.xiaohe66.demo.zookeeper.lock.mapper")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
