package com.xiaohe66.demo.redis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author xh
 * @date 18-12-11 011
 */
public class RedisDemo {

    @Test
    public void test1(){

        Jedis jedis = new Jedis("localhost",6379);

        System.out.println(jedis.get("name"));

        jedis.set("name","小何");

        System.out.println(jedis.get("name"));

        jedis.set("name","何少");

        System.out.println(jedis.get("name"));

        jedis.del("name");

        System.out.println(jedis.get("name"));

    }


    @Test
    public void test2(){

        //连接池配置
        JedisPoolConfig config = new JedisPoolConfig();

        //最大连接
        config.setMaxTotal(30);

        //最大空闲连接
        config.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(config,"localhost",6379);

        Jedis jedis = jedisPool.getResource();

        System.out.println(jedis.get("name"));

        jedis.set("name","小何");

        System.out.println(jedis.get("name"));

        jedis.set("name","何少");

        System.out.println(jedis.get("name"));

        jedis.del("name");

        System.out.println(jedis.get("name"));

        jedis.close();
    }

}
