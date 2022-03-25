package com.xiaohe66.demo.cloud2.order.controller;

import com.xiaohe66.demo.cloud.stock.feign.service.ProductStockFeignService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaohe
 * @since 2022.02.09 15:26
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final ProductStockFeignService productStockFeignService;

    @Value("${server.port}")
    private int port;

    @PostMapping("/order/{productId}")
    public String test(@PathVariable Long productId) {

        String response = productStockFeignService.subStock(productId);

        log.info("({})下订单 : {}, 减库存 : {}", port, productId, response);

        return "订单成功(" + port + ")";
    }

}
