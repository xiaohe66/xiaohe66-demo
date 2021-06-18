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
@ContextConfiguration(locations = "classpath:spring/spring-rabbitmq-pubsub.xml")
public class SpringPubsubTest {

    private static final Logger log = LoggerFactory.getLogger(SpringPubsubTest.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test1() {

        rabbitTemplate.convertAndSend(Const.SPRING_FANOUT_EXCHANGE,"", "广播消息, 当前时间： "+ LocalTime.now());

        log.info("发送消息完成");
    }
}
