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
 * @time 2021.06.18 15:57
 */
@Configuration
public class RoutingConfig {

    private static final Logger log = LoggerFactory.getLogger(RoutingConfig.class);

    @RabbitListener(queues = Const.SPRING_ROUTING_QUEUE)
    public void rabbitmqListener(Message message) {

        if (log.isInfoEnabled()) {

            MessageProperties properties = message.getMessageProperties();

            log.info("Routing 监听到第{}条消息 : {}", properties.getDeliveryTag(), new String(message.getBody()));

        }

    }
}
