package com.xiaohe66.demo.cloud2.user;

import com.xiaohe66.demo.cloud2.user.feign.OrderFeignService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaohe
 * @since 2022.02.09 15:26
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final RestTemplate restTemplate;
    private final OrderFeignService orderFeignService;

    @GetMapping(value = "/echo/{str}")
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject("http://service-order/order/" + str, String.class);
    }

    @GetMapping(value = "/feign/{str}")
    public String feign(@PathVariable String str) {
        // 使用 feign 进行调用
        // NOTE : feign 只是对调用的过程进行了封装，其本质还是会使用 ribbon 的负载均衡
        return orderFeignService.test(str);
    }

    @GetMapping(value = "/feign/mockErr")
    public String mockErr() {
        // 模拟调用不存在的服务
        try {
            return orderFeignService.mockErr("mock");

        } catch (FeignException e) {
            log.error("feign request error, status : {}, response : {}", e.status(), e.contentUTF8());

            return "error";

        } catch (Exception e) {
            log.error("catch Exception", e);
            return e.getMessage();
        }
    }

}
