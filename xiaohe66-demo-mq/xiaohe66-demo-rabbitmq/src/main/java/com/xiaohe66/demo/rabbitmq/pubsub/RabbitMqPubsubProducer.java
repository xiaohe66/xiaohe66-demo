package com.xiaohe66.demo.rabbitmq.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xiaohe66.demo.rabbitmq.Const;
import com.xiaohe66.demo.rabbitmq.RabbitMqUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

/**
 * 订阅模式
 * 我的理解是 观察者模式
 * 每个生产者的消息，都会发给一个 exchange中，然后通过 exchange 发给绑定到自己的 queue中，消费者在自己的queue中取消息。
 * <p>
 * 整体的实现，和观察者模式一样。
 *
 * @author xiaohe
 * @time 2021.06.04 14:57
 */
public class RabbitMqPubsubProducer {

    private static final Logger log = LoggerFactory.getLogger(RabbitMqPubsubProducer.class);

    public static void main(String[] args) throws IOException, TimeoutException {

        try (Connection connection = RabbitMqUtils.newConnection();
             Channel channel = connection.createChannel()) {

            String message = "明天放晴";
            int qty = 100;

            // 推送消息，由于是广播到匹配的队列中，因此不需要指定队列。但需要指定交换机
            // note : 如果交换机没有绑定任何一个队列，则这条消息会丢失
            for (int i = 0; i < qty; i++) {
                String msg = message + i;
                channel.basicPublish(Const.PUBSUB_EXCHANGE_NAME, Const.PUBSUB_ROUTING_KEY, null, msg.getBytes());
            }

            log.info("推送消息成功, time : {}", LocalDateTime.now());
        }

    }

}
