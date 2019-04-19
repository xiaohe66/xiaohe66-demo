package com.xiaohe66.demo.cloud.controller;

import com.xiaohe66.demo.cloud.api.UserApi;
import com.xiaohe66.demo.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xh
 * @date 19-03-05 005
 */
@RestController
public class TestController {

    private RestTemplate restTemplate;

    @Autowired
    private UserApi userApi;

    @GetMapping("/hello")
    public String test1() {
        return "Hello world, order-8100";
    }


    @GetMapping("/invoke")
    public User test2(){
        String url = "http://MS-CONSUMER-USER/invoke";
        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(url,User.class);
        return userResponseEntity.getBody();
    }

    @GetMapping("/invoke2")
    public User test3(){
        return userApi.invoke();
    }
}
