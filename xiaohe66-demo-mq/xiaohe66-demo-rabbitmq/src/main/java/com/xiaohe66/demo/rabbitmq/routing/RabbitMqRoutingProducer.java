package com.xiaohe66.demo.rabbitmq.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
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
 * 匹配模式
 * <p>
 * 只有当 routing key 相同时，才能接收到消息
 *
 * @author xiaohe
 * @time 2021.06.04 14:57
 */
public class RabbitMqRoutingProducer {

    private static final Logger log = LoggerFactory.getLogger(RabbitMqRoutingProducer.class);

    public static void main(String[] args) throws IOException, TimeoutException {

        Map<String, String> messageMap = new HashMap<>();

        messageMap.put("routing.sh.210608", "上海6月8");
        messageMap.put("routing.gz.210608", "广州6月8");
        messageMap.put("routing.sz.210608", "深圳6月8");

        messageMap.put("routing.sh.210607", "上海6月7");
        messageMap.put("routing.gz.210607", "广州6月7");
        messageMap.put("routing.sz.210607", "深圳6月7");

        try (Connection connection = RabbitMqUtils.newConnection();
             Channel channel = connection.createChannel()) {

            for (Map.Entry<String, String> entry : messageMap.entrySet()) {

                // 需要先去管理页面创建交换机
                channel.basicPublish(Const.ROUTING_EXCHANGE_NAME, entry.getKey(), null, entry.getValue().getBytes());
            }

            log.info("推送消息成功, time : {}", LocalDateTime.now());
        }

    }

}
