package com.xiaohe66.demo.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiaohe
 * @time 2021.04.25 15:23
 */
public class JedisTest {

    private JedisPool jedisPool = new JedisPool("192.168.181.128", 6379);

    @Test
    public void test1() {

        try (Jedis redis = jedisPool.getResource()) {

            System.out.println(redis.set("xiaohe66", LocalDateTime.now().toString()));
            System.out.println(redis.get("xiaohe66"));
        }
    }

    // 管道
    @Test
    public void test2() {

        try (Jedis redis = jedisPool.getResource()) {

            Pipeline pipeline = redis.pipelined();

            for (int i = 0; i < 5; i++) {
                pipeline.set("xiaohe" + i, Integer.toString(i));
            }

            List<Object> retList = pipeline.syncAndReturnAll();
            for (Object ret : retList) {
                System.out.println(ret);
            }

        }

    }

    // Lua脚本，Lua脚本执行时具有原子性
    @Test
    public void test3() {

        try (Jedis redis = jedisPool.getResource()) {

            //language=TEXT
            String lua = " local qtyStr = redis.call('get',KEYS[1])" +
                    " local qty = tonumber(qtyStr)" +
                    " local b = tonumber(ARGV[1])" +
                    " if qty >= b then" +
                    "   redis.call('set',KEYS[1], qty-b)" +
                    "   return 1" +
                    " end" +
                    " return 0 ";

            Object ret = redis.eval(lua, Arrays.asList("qty"), Arrays.asList("2"));

            System.out.println(ret);

        }
    }

}
