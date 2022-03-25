package com.xiaohe66.demo.cloud2.product.controller;

import com.xiaohe66.demo.cloud.stock.feign.service.ProductStockFeignService;
import com.xiaohe66.demo.cloud2.product.ret.ProductRet;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaohe
 * @since 2022.03.25 15:20
 */
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductStockFeignService productStockFeignService;

    @Value("${server.port}")
    private int port;

    @GetMapping("/product/{id}")
    public ProductRet request(@PathVariable("id") Long id) {

        Long stock = productStockFeignService.getStock(id);

        ProductRet ret = new ProductRet();

        ret.setId(id);
        ret.setName("霸王洗发水");
        ret.setStock(stock);

        ret.setPort(port);

        return ret;
    }

}
