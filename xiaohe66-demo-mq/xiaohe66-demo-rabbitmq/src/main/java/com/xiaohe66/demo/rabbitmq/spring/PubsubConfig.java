package com.xiaohe66.demo.rabbitmq.spring;

import com.xiaohe66.demo.rabbitmq.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * 发布/订阅(广播模式)
 *
 * @author xiaohe
 * @time 2021.06.08 18:20
 */
@Configuration
public class PubsubConfig {

    private static final Logger log = LoggerFactory.getLogger(PubsubConfig.class);

    @RabbitListener(queues = Const.SPRING_FANOUT_QUEUE_1)
    public void rabbitMqListener1(Message message) {
        if (log.isInfoEnabled()) {

            MessageProperties properties = message.getMessageProperties();

            log.info("1号 监听到第{}条消息 : {}", properties.getDeliveryTag(), new String(message.getBody()));
        }
    }

    @RabbitListener(queues = Const.SPRING_FANOUT_QUEUE_2)
    public void rabbitMqListener2(Message message) {
        if (log.isInfoEnabled()) {

            MessageProperties properties = message.getMessageProperties();

            log.info("2号 监听到第{}条消息 : {}", properties.getDeliveryTag(), new String(message.getBody()));
        }
    }

}
