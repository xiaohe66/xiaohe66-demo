package com.xiaohe66.demo.cloud2.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author xiaohe
 * @since 2022.02.09 15:26
 */
@RestController
public class OrderController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/order/{string}")
    public String test(@PathVariable String string, @RequestHeader Map<String,String> headers) {

        return String.format("订单(%s), 提交的参数 : %s, headers : %s", port, string, headers);
    }

}
