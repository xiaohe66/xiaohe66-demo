package com.xiaohe66.demo.rabbitmq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaohe
 * @time 2021.06.23 11:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-rabbitmq-return.xml")
public class SpringConfirmTest {

    private static final Logger log = LoggerFactory.getLogger(SpringConfirmTest.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void test1() throws InterruptedException {

        // 重要： 消息确认，必须要在connectionFactory 中设置 publisher-confirms="true"
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             * Confirmation callback.
             * @param correlationData correlation data for the callback.
             * @param ack true for ack, false for nack
             * @param cause An optional cause, for nack, when available, otherwise null.
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {

                String msg = "";
                String id = "";
                if (correlationData != null) {
                    id = correlationData.getId();
                    Message message = correlationData.getReturnedMessage();
                    if (message != null) {
                        msg = new String(message.getBody());
                    }
                }

                log.info("消息接受 : {}, 消息id : {}, 消息内容 : {}", ack ? "成功" : "失败", id, msg);

            }
        });

        for (int i = 0; i < 5; i++) {

            // 什么时候会回调 confirm：当消息到了 rabbitmq，但找不到相应的交换机时。
            // 这里的交换机名称 要填不存在的
            rabbitTemplate.convertAndSend("spring_confirm_exchange", "confirm", "测试确认消息.." + i);
        }

        // 如果线程关闭了，则无法获取到确认消息
        TimeUnit.SECONDS.sleep(10);
    }
}
