package com.xiaohe66.demo.cloud.api;

import com.xiaohe66.demo.cloud.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaohe
 * @date 2019.04.19 19:24
 */
@FeignClient(name = "ms-consumer-user")
public interface UserApi {

    /**
     * invoke
     * @return User
     */
    @RequestMapping("/invoke")
    User invoke();
}
