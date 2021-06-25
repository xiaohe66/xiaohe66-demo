package com.xiaohe66.demo.rabbitmq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xiaohe
 * @time 2021.06.23 11:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-rabbitmq-dead.xml")
public class SpringDeadTest {

    private static final Logger log = LoggerFactory.getLogger(SpringDeadTest.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void test1() throws InterruptedException {

        for (int i = 0; i < 5; i++) {

            rabbitTemplate.convertAndSend("spring_dead_ttl_exchange", "ttl_dead_test", "测试 延迟队列 .." + i);
        }
    }
}
