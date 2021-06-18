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
 * @time 2021.06.18 16:18
 */
@Configuration
public class TopicConfig {

    private static final Logger log = LoggerFactory.getLogger(TopicConfig.class);

    @RabbitListener(queues = Const.SPRING_TOPIC_QUEUE_A)
    public void rabbitmqListener(Message message) {

        if (log.isInfoEnabled()) {

            MessageProperties properties = message.getMessageProperties();

            log.info("topic A 监听到第{}条消息 : {}", properties.getDeliveryTag(), new String(message.getBody()));
        }
    }

    @RabbitListener(queues = Const.SPRING_TOPIC_QUEUE_B)
    public void rabbitmqListenerB(Message message) {

        if (log.isInfoEnabled()) {

            MessageProperties properties = message.getMessageProperties();

            log.info("topic B 监听到第{}条消息 : {}", properties.getDeliveryTag(), new String(message.getBody()));
        }
    }

}
