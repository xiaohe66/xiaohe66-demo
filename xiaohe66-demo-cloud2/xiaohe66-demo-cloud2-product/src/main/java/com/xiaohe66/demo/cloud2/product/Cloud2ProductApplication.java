package com.xiaohe66.demo.cloud2.product;

import com.xiaohe66.demo.cloud.stock.feign.ProductStockFeign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xiaohe
 * @since 2022.03.25 15:19
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients(basePackageClasses = ProductStockFeign.class)
public class Cloud2ProductApplication {

    public static void main(String[] args) {

        SpringApplication.run(Cloud2ProductApplication.class, args);

    }

}
