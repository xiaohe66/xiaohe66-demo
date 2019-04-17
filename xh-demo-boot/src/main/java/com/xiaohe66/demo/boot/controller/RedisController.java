package com.xiaohe66.demo.boot.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xh
 * @date 18-12-12 012
 */
@RestController
public class RedisController {

    private RedisTemplate<Object,Object> redisTemplate;

    public RedisController(RedisTemplate<Object,Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/redis/{key}/{val}")
    public String test(@PathVariable("key")String key,@PathVariable("val")String val){

        System.out.println("key:"+key+",val:"+val);

        ValueOperations<Object,Object> operations = redisTemplate.opsForValue();

        operations.set(key,val);

        return String.valueOf(operations.get(key));

    }

}
