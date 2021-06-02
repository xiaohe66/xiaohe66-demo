package com.xiaohe66.demo.cloud.user.controller;

import com.xiaohe66.demo.cloud.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xh
 * @date 19-03-05 005
 */
@RestController
@Slf4j
public class UserController {

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

    @GetMapping("/error/{userId}")
    public User error(@PathVariable Integer userId){
        if(userId == 1){
            throw new RuntimeException("test exception");
        }
        return new User(1,port);
    }

    @GetMapping("/timeout/{mills}")
    public User timeout(@PathVariable Long mills) throws InterruptedException {
        log.info("调用超时方法，超时时间：{}", mills);
        Thread.sleep(mills);
        return new User(1,port);
    }


}
