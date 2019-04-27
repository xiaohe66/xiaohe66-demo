package com.xiaohe66.demo.cloud.order.cfg;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.xiaohe66.demo.cloud.common.entity.User;
import com.xiaohe66.demo.cloud.order.api.UserApi;

/**
 * @author xiaohe
 * @date 2019.04.26 19:57
 */
public class XhHystrixCommand extends HystrixCommand<User> {

    private final UserApi userApi;

    private final Integer userId;

    public XhHystrixCommand(String commandGroupKey, UserApi userApi, Integer userId) {
        super(HystrixCommandGroupKey.Factory.asKey(commandGroupKey));
        this.userApi = userApi;
        this.userId = userId;
    }

    @Override
    protected User run() throws Exception {
        return userApi.error(userId);
    }

    @Override
    protected User getFallback() {
        return new User(1,"XhHystrixCommand 的错误用户");
    }
}
