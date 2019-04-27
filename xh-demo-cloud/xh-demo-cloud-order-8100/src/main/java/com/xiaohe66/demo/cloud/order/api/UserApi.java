package com.xiaohe66.demo.cloud.order.api;

import com.xiaohe66.demo.cloud.common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaohe
 * @date 2019.04.26 22:47
 */
@FeignClient(name = "ms-consumer-user",fallback = UserApiFallback.class)
public interface UserApi {
    /**
     * invoke
     * @return User
     */
    @RequestMapping("/invoke")
    User invoke();

    /**
     * user
     * @return User
     */
    @RequestMapping("/error/{userId}")
    User error(@PathVariable Integer userId);

    /**
     * user
     * @return User
     */
    @RequestMapping("/timeout/{mills}")
    User timeout(@PathVariable Long mills);
}
