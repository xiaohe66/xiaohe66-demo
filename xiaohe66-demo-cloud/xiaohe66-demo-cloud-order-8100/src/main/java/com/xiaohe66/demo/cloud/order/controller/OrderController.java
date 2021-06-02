package com.xiaohe66.demo.cloud.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xiaohe66.demo.cloud.common.entity.User;
import com.xiaohe66.demo.cloud.order.api.UserApi;
import com.xiaohe66.demo.cloud.order.cfg.XhHystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xh
 * @date 19-03-05 005
 */
@RestController
public class OrderController {

    @Autowired
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

    @GetMapping("/error1/{userId}")
    public User error(@PathVariable Integer userId){
        XhHystrixCommand hystrixCommand = new XhHystrixCommand("userGroupKey",userApi,userId);
        return hystrixCommand.execute();
    }

    @GetMapping("/error2/{userId}")
    @HystrixCommand(fallbackMethod ="errorFallBack",commandKey = "error2")
    public User error2(@PathVariable Integer userId){
        return userApi.error(userId);
    }

    @GetMapping("/timeout/{mills}")
    public User timeout(@PathVariable Long mills){
        return userApi.timeout(mills);
    }

    /**
     * note : 由于 userApi配置了 failBack 属性，因此 @HystrixCommand 没有生效
     */
    private User errorFallBack(Integer userId){
        return new User(userId,"错误用户");
    }


}
