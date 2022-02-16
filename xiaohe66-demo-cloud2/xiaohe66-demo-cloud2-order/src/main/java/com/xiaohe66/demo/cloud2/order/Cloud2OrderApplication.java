package com.xiaohe66.demo.cloud2.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 在启动时的 VM option 中添加 -Dserver.port=8082 以指定端口
 *
 * @author xiaohe
 * @since 2022.02.09 15:25
 */
@SpringBootApplication
public class Cloud2OrderApplication {

    public static void main(String[] args) {

        SpringApplication.run(Cloud2OrderApplication.class, args);
    }
}
