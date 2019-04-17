package com.xiaohe66.demo.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xh
 * @date 19-03-05 005
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String test1() {
        return "Hello world, order-8100";
    }

}
