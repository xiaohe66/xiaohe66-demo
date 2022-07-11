package com.xiaohe66.demo.spring.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaohe
 * @since 2022.07.06 10:58
 */
@RestController
public class SpringTestController {



    @GetMapping("/test/hello")
    public String query(){
        System.out.println("hello junit");
        return "ok";
    }

}
