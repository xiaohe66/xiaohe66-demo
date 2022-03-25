package com.xiaohe66.demo.cloud2.stock.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaohe
 * @since 2022.03.25 11:53
 */
@RestController
@RequestMapping("/product/stock")
@Slf4j
public class ProductStockController {

    @Value("${server.port}")
    private int port;

    @PostMapping("/sub/{productId}")
    public String subStock(@PathVariable Long productId) {

        log.info("({})减库存 : {}", port, productId);

        return "减库存成功";
    }

    @GetMapping("/{productId}")
    public Long getStock(@PathVariable Long productId) {

        log.info("({})减库存 : {}", port, productId);

        return 1000L;
    }

}
