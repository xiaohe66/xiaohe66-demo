package com.xiaohe66.demo.rabbitmq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
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
public class SpringReturnTest {

    private static final Logger log = LoggerFactory.getLogger(SpringReturnTest.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void test1() throws InterruptedException {

        //设置交换机处理失败消息的模式为true的时候，消息达到不了队列时，会将消息重新返回给生产者
        rabbitTemplate.setMandatory(true);

        // 重要： 消息确认，必须要在connectionFactory 中设置 publisher-confirms="true"
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /**
             * Returned message callback.
             * @param message the returned message.
             * @param replyCode the reply code.
             * @param replyText the reply text.
             * @param exchange the exchange.
             * @param routingKey the routing key.
             */
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {

                log.info("return被执行了, message : {}, replyCode : {}, replyText : {}, exchange : {}, routingKey : {}",
                        new String(message.getBody()), replyCode, replyText, exchange, routingKey);
            }
        });

        for (int i = 0; i < 10; i++) {
            // 什么时候会回调 return：当消息到了 exchange，但找不到相应队列时
            // 这里的routingKey名称，正确的是：return
            String routingKey = (i % 3 == 0 ? "return" : "err");
            rabbitTemplate.convertAndSend("spring_return_exchange", routingKey, "测试确认消息.." + i);
        }

        // 如果线程关闭了，则无法获取到确认消息
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
