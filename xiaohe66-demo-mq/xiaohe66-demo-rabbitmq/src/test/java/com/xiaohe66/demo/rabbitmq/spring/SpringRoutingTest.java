package com.xiaohe66.demo.rabbitmq.spring;

import com.xiaohe66.demo.rabbitmq.Const;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalTime;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-rabbitmq-routing.xml")
public class SpringRoutingTest {

    private static final Logger log = LoggerFactory.getLogger(SpringRoutingTest.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test1() {

        // routingKey 需要和 queue 绑定，当 routingKey 相同时，才会被发送到 queue中
        // 若不存在任何 queue 与 routingKey 对应，则这条消息会丢失。
        rabbitTemplate.convertAndSend(Const.SPRING_ROUTING_EXCHANGE, "info", "Hello rabbitmq, routing , " + LocalTime.now());

        log.info("发送消息完成");
    }
}
