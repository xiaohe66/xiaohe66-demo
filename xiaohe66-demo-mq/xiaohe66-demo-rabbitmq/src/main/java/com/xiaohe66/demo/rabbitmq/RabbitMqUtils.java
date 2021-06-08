package com.xiaohe66.demo.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author xiaohe
 * @time 2021.06.04 14:54
 */
public class RabbitMqUtils {

    private static final ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("vm.com");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("test1");
        connectionFactory.setPassword("test1");
        connectionFactory.setVirtualHost("test_host");
    }

    private RabbitMqUtils() {

    }

    public static Connection newConnection() throws IOException, TimeoutException {
        return connectionFactory.newConnection();
    }

}
