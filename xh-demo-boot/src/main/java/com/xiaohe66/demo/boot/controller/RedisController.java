package com.xiaohe66.demo.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xh
 * @date 18-12-12 012
 */
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/redis/test")
    public String test(){

        stringRedisTemplate.opsForValue().set("name","小何");

        return stringRedisTemplate.opsForValue().get("name");

    }

}
