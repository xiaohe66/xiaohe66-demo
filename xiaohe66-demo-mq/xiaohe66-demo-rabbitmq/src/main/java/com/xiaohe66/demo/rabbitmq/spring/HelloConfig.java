package com.xiaohe66.demo.rabbitmq.spring;

import com.xiaohe66.demo.rabbitmq.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohe
 * @time 2021.06.18 14:12
 */
@Configuration
public class HelloConfig {

    private static final Logger log = LoggerFactory.getLogger(HelloConfig.class);

    @RabbitListener(queues = Const.SPRING_HELLO_QUEUE_NAME)
    public void rabbitListener(Message message) {
        if (log.isInfoEnabled()) {

            MessageProperties properties = message.getMessageProperties();

            log.info("监听到第{}条消息 : {}", properties.getDeliveryTag(), new String(message.getBody()));
        }
    }

}
