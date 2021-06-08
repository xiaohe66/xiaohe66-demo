package com.xiaohe66.demo.rabbitmq.workqueue;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.xiaohe66.demo.rabbitmq.RabbitMqUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author xiaohe
 * @time 2021.06.02 18:19
 */
public class RabbitMqConsumer {

    /**
     * 可以创建多个消费者，但一条消息只能被一个消费者取走
     */
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        try (Connection connection = RabbitMqUtils.newConnection();
             Channel channel = connection.createChannel()) {

            /*
             * 创建队列,声明并创建一个队列，如果队列已存在，则使用这个队列
             *
             * queue： 队列名称
             * durable: 是否持久化，false对应不持久化数据，MQ停掉数据就会丢失
             * exclusive : 是否队列私有化，false则代表所有消费者都可以访问，true代表只有第一次拥有它的消费者才能一直使用，其他消费者不让访问
             * autoDelete：是否自动删除,false代表连接停掉后不自动删除掉这个队列
             * arguments：其他额外的参数
             * */
            channel.queueDeclare("helloworld", false, false, false, null);

            /*
             * 创建一个消息消费者，消费者可以取得之前生产的消息，也可以取得之后生产的消息
             * queue :队列名
             * callback : 回调
             * */
            channel.basicConsume("helloworld", new DefaultConsumer(channel) {

                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                    String message = new String(body);

                    System.out.println("接收到消息：" + message);
                    System.out.println("消息Tag：" + envelope.getDeliveryTag());

                    //false只确认签收当前的消息，设置为true的时候则代表签收该消费者所有未签收的消息
                    channel.basicAck(envelope.getDeliveryTag(), false);

                }
            });

            System.out.println("客户端启动完成");

            // note : 在此休眠，防止退出这个代码块导致连接被 close
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        }

    }

}
