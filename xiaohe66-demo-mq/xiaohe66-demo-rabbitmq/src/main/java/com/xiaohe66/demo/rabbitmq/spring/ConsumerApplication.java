package com.xiaohe66.demo.rabbitmq.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaohe
 * @time 2021.06.08 17:26
 */
@SpringBootApplication
public class ConsumerApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsumerApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(ConsumerApplication.class, args);
        log.info("消费者启动完成");
    }

}
