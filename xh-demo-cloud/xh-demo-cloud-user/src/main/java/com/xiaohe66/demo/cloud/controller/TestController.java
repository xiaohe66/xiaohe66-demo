package com.xiaohe66.demo.cloud.controller;

import com.xiaohe66.demo.cloud.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xh
 * @date 19-03-05 005
 */
@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String test1() {
        return "Hello world, "+port;
    }

    @GetMapping("/invoke")
    public User test2(){
        return new User(1,port);
    }

}
