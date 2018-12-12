package com.xiaohe66.demo.boot.controller;

import com.xiaohe66.demo.boot.data.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xh
 * @date 18-12-11 011
 */
@RestController
public class HelloController {

    @Resource
    private Param param;

    @GetMapping("/hello")
    public String hello(){
        return "Hello world!";
    }

    @GetMapping("/param")
    public String hello2(){
        return param.getName()+","+param.getWebsite()+","+param.getLanguage();
    }

}
