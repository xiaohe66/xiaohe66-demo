package com.xiaohe66.demo.cloud.stock.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author xiaohe
 * @since 2022.03.25 12:03
 */
@FeignClient(value = "service-stock", path = "/product/stock")
public interface ProductStockFeignService {

    @PostMapping("/sub/{productId}")
    String subStock(@PathVariable("productId") Long productId);

    @GetMapping("/{productId}")
    Long getStock(@PathVariable("productId") Long productId);

}
