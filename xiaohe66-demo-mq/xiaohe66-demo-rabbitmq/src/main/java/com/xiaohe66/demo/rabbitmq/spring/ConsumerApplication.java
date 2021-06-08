package com.xiaohe66.demo.rabbitmq.spring;

import com.xiaohe66.demo.rabbitmq.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaohe
 * @time 2021.06.08 17:26
 */
@SpringBootApplication
public class ConsumerApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsumerApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(ConsumerApplication.class, args);
        log.info("消费者启动完成");

    }

    @RabbitListener(queues = Const.SPRING_QUEUE_NAME)
    public void rabbitMqListener(Message message) {

        if (log.isInfoEnabled()) {

            MessageProperties properties = message.getMessageProperties();

            log.info("监听到第{}条消息 : {}", properties.getDeliveryTag(), new String(message.getBody()));
        }

    }
}
