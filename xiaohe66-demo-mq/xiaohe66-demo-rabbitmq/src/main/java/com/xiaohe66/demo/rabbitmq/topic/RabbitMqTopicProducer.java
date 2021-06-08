package com.xiaohe66.demo.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Return;
import com.rabbitmq.client.ReturnCallback;
import com.xiaohe66.demo.rabbitmq.Const;
import com.xiaohe66.demo.rabbitmq.RabbitMqUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * 通配符号模式
 * 符号：* 匹配1个单词
 * 箱号：# 匹配多个单词
 *
 * @author xiaohe
 * @time 2021.06.04 14:57
 */
public class RabbitMqTopicProducer {

    private static final Logger log = LoggerFactory.getLogger(RabbitMqTopicProducer.class);

    public static void main(String[] args) throws IOException, TimeoutException {

        Map<String, String> messageMap = new HashMap<>();

        messageMap.put("topic.sh.210608", "上海6月8");
        messageMap.put("topic.gz.210608", "广州6月8");
        messageMap.put("topic.sz.210608", "深圳6月8");

        messageMap.put("topic.sh.210607", "上海6月7");
        messageMap.put("topic.gz.210607", "广州6月7");
        messageMap.put("topic.sz.210607", "深圳6月7");

        // return 模式不能 close
        Connection connection = RabbitMqUtils.newConnection();
        Channel channel = connection.createChannel();

        // 打开监听模式
        channel.confirmSelect();

        // confirm ： 生产发 --> MQ服务端
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                // multiple ： 服务器是否为批量接收
                log.info("消息被服务器接收, tag : {}", deliveryTag);
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                log.error("消息被服务器拒收, tag : {}", deliveryTag);
            }
        });

        // return ： 当消息无法被消费时回调用该方法，需要在发布消息时设置回退属性
        channel.addReturnListener(new ReturnCallback() {
            @Override
            public void handle(Return msg) {
                log.info("Return Code : {}, return Value : {}, exchange : {}, routing key : {}, return body : {}",
                        msg.getReplyCode(), msg.getReplyText(), msg.getExchange(), msg.getRoutingKey(), new String(msg.getBody()));
            }
        });

        for (Map.Entry<String, String> entry : messageMap.entrySet()) {

            // note : 第3个参数设置为true代表如果消息无法正常投递则return回生产者，如果false，则直接将消息放弃
            channel.basicPublish(Const.TOPIC_EXCHANGE_NAME, entry.getKey(), true, null, entry.getValue().getBytes());
        }

        log.info("推送消息成功, time : {}", LocalDateTime.now());

    }

}
