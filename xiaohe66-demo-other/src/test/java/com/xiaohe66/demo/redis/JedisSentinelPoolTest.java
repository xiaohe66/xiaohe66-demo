package com.xiaohe66.demo.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaohe
 * @time 2021.04.25 17:26
 */
public class JedisSentinelPoolTest {

    @Test
    public void test1() {


        Set<String> sentinels = new HashSet<>();

        sentinels.add("192.168.181.128:26379");
        sentinels.add("192.168.181.128:26380");
        sentinels.add("192.168.181.128:26381");

        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMinIdle(5);

        JedisSentinelPool pool = new JedisSentinelPool("mymaster", sentinels, config);

        for (int i = 0; i < 100; i++) {
            try (Jedis jedis = pool.getResource()) {

                System.out.println(jedis.set("sentinel", LocalDateTime.now().toString()));
                System.out.println(jedis.get("sentinel"));
                Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
