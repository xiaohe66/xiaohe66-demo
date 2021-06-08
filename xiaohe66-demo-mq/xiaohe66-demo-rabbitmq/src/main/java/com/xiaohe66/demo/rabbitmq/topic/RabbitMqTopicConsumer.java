package com.xiaohe66.demo.rabbitmq.topic;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.xiaohe66.demo.rabbitmq.Const;
import com.xiaohe66.demo.rabbitmq.RabbitMqUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author xiaohe
 * @time 2021.06.04 14:57
 */
public class RabbitMqTopicConsumer {

    private static final Logger log = LoggerFactory.getLogger(RabbitMqTopicConsumer.class);

    public void createConsumer(String queueName, long sleepMs, String... keys) throws IOException, TimeoutException {

        // 不 close，让消费者一直监听
        Connection connection = RabbitMqUtils.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(queueName, false, false, false, null);

        // 绑定路由
        for (String key : keys) {
            channel.queueBind(queueName, Const.TOPIC_EXCHANGE_NAME, key);
        }

        channel.basicConsume(queueName, new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body);

                log.info("{}接收到第{}条信息：{}", queueName, envelope.getDeliveryTag(), message);

                try {
                    TimeUnit.MILLISECONDS.sleep(sleepMs);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }

    public static void main(String[] args) throws IOException, TimeoutException {

        RabbitMqTopicConsumer demo = new RabbitMqTopicConsumer();

        /*
         * 符号：* 匹配1个单词
         * 箱号：# 匹配多个单词
         * */
        demo.createConsumer("topic_baidu", 1, "#.210607");

        demo.createConsumer("topic_google", 1, "topic.gz.*");

        System.out.println("消耗者启动完成");
    }

}
