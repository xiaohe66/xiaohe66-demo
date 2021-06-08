package com.xiaohe66.demo.rabbitmq.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xiaohe66.demo.rabbitmq.RabbitMqUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

/**
 * @author xiaohe
 * @time 2021.06.02 18:01
 */
public class RabbitMqProducer {

    public static void main(String[] args) throws IOException, TimeoutException {

        try (Connection connection = RabbitMqUtils.newConnection();
             Channel channel = connection.createChannel()) {

            String message = "a new massage";


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
             * 推送一条消息到服务器，这条消息可以被服务器缓存。直到被消费者取走。
             * exchange : 交换机
             * routingKey :  队列名称
             * props :   额外的设置属性
             * body : 消息
             *
             * */
            channel.basicPublish("", "helloworld", null, message.getBytes());
            channel.basicPublish("", "helloworld", null, message.getBytes());
            channel.basicPublish("", "helloworld", null, message.getBytes());
            channel.basicPublish("", "helloworld", null, message.getBytes());
            channel.basicPublish("", "helloworld", null, message.getBytes());
            channel.basicPublish("", "helloworld", null, message.getBytes());
            channel.basicPublish("", "helloworld", null, message.getBytes());


            System.out.println("推送消息成功..." + LocalDateTime.now());
        }

    }

}
