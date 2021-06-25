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
 * @time 2021.06.23 11:47
 */
@Configuration
public class DeadConfig {

    private static final Logger log = LoggerFactory.getLogger(DeadConfig.class);

    @RabbitListener(queues = Const.SPRING_DEAD_QUEUE)
    public void confirmListener(Message message) {

        MessageProperties properties = message.getMessageProperties();
        long deliveryTag = properties.getDeliveryTag();

        String body = new String(message.getBody());


        log.info("tag : {}, body : {}", deliveryTag, body);
    }

}
