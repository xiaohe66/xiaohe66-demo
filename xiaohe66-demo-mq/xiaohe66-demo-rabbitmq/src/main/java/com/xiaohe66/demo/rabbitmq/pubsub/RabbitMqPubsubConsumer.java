package com.xiaohe66.demo.rabbitmq.pubsub;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
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
public class RabbitMqPubsubConsumer {

    private static final Logger log = LoggerFactory.getLogger(RabbitMqPubsubConsumer.class);

    private void createConsumer(String name, long sleepMs) throws IOException, TimeoutException {

        // 不 close，让消费者一直监听
        Connection connection = RabbitMqUtils.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(name, false, false, false, null);

        // 表示消费一个，再去取一个。不设置这个参数时，会平均分配给所有消费者
        // 设置这个后，给每个消费者设置不同的延迟，则可以看出每个消费的数量是不同的
        channel.basicQos(1);

        channel.basicConsume(name, new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body);

                log.info("{}接收到天气第{}条信息：{}", name, envelope.getDeliveryTag(), message);

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
        RabbitMqPubsubConsumer consumer = new RabbitMqPubsubConsumer();

        consumer.createConsumer("gd", 500);
        consumer.createConsumer("bj", 100);
        consumer.createConsumer("sh", 10);

        log.info("消费者启动完成");
    }

}
