package com.xiaohe66.demo.rabbitmq;

/**
 * @author xiaohe
 * @time 2021.06.04 14:59
 */
public class Const {

    public static final String PUBSUB_EXCHANGE_NAME = "pubsub_ex";
    public static final String PUBSUB_ROUTING_KEY = "pubsub";

    public static final String ROUTING_EXCHANGE_NAME = "routing_ex";

    public static final String TOPIC_EXCHANGE_NAME = "topic_ex";

    public static final String SPRING_HELLO_QUEUE_NAME = "spring_hello_queue";

    public static final String SPRING_FANOUT_EXCHANGE = "spring_fanout_exchange";
    public static final String SPRING_FANOUT_QUEUE_1 = "spring_fanout_queue_1";
    public static final String SPRING_FANOUT_QUEUE_2 = "spring_fanout_queue_2";

    public static final String SPRING_ROUTING_EXCHANGE = "spring_direct_exchange";
    public static final String SPRING_ROUTING_QUEUE = "spring_routing_queue";

    public static final String SPRING_TOPIC_EXCHANGE = "spring_topic_exchange";
    public static final String SPRING_TOPIC_QUEUE_A = "spring_topic_queue_a";
    public static final String SPRING_TOPIC_QUEUE_B = "spring_topic_queue_b";

}
