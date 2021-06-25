package com.xiaohe66.demo.rabbitmq.spring;

import com.rabbitmq.client.Channel;
import com.xiaohe66.demo.rabbitmq.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaohe
 * @time 2021.06.23 11:47
 */
@Configuration
public class ReturnConfig {

    private static final Logger log = LoggerFactory.getLogger(ReturnConfig.class);

    @RabbitListener(queues = Const.SPRING_RETURN_QUEUE)
    public void confirmListener(Message message, Channel channel) throws IOException, InterruptedException {

        MessageProperties properties = message.getMessageProperties();
        long deliveryTag = properties.getDeliveryTag();

        String body = new String(message.getBody());

        TimeUnit.SECONDS.sleep(1);

        if (deliveryTag % 2 == 0) {

            log.info("接收到消息，消费, id : {}, body : {}", deliveryTag, body);

            // 若出现 Channel closed; cannot ack/nack，则说明没有关闭自己应答：
            // spring-rabbitmq-listener-simple-acknowledge-mode = true
            channel.basicAck(deliveryTag, false);

        } else {

            log.error("接收到消息，拒绝, id : {}, body : {}", deliveryTag, body);

            // 第三个参数：requeue：重回队列。如果设置为true，则消息重新回到queue，broker会重新发送该消息给消费端
            channel.basicNack(deliveryTag, false, true);
        }
    }

}
