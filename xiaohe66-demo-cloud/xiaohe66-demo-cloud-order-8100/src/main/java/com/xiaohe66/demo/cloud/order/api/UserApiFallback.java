package com.xiaohe66.demo.cloud.order.api;

import com.xiaohe66.demo.cloud.common.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author xiaohe
 * @date 2019.04.26 22:48
 */
@Component
public class UserApiFallback implements UserApi{


    @Override
    public User invoke() {
        return new User(null,"降级的方法invoke方法");
    }

    @Override
    public User error(Integer userId) {
        return new User(null,"降级的方法error方法");
    }

    @Override
    public User timeout(Long mills) {
        return new User(null,"降级的方法timeout方法");
    }
}
