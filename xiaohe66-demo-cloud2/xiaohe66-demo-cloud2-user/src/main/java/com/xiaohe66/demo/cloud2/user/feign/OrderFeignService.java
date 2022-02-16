package com.xiaohe66.demo.cloud2.user.feign;

import com.xiaohe66.demo.cloud2.user.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xiaohe
 * @since 2022.02.16 11:13
 */
@FeignClient(value = "service-order", path = "/order"
        // 此外的configuration配置，可以单独指定当前 feign 的日志输出级别。当注释掉该配置后，就没有日志输出了
        // 若想在生产环境中配置输入，则需要配置当前类的输出级别为 debug
        // ,configuration = FeignConfig.class
)
public interface OrderFeignService {

    /**
     * 该方法调用的请求地址为： http://service-order/order/{str}
     */
    @GetMapping("/{str}")
    String test(@PathVariable("str") String str);

    @GetMapping("/mockErr/{str}")
    String mockErr(@PathVariable("str") String str);
}
