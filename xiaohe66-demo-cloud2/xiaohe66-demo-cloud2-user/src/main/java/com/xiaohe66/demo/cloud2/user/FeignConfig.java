package com.xiaohe66.demo.cloud2.user;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohe
 * @since 2022.02.17 11:04
 */
// @Configuration // 加上该注解后，配置就会全局生效（调用所有服务）。若需要局部有效，则需要使用别的方式
public class FeignConfig {

    /**
     * 定义feign的日志输入级别
     *
     * <p>
     * NONE【性能最佳，适用于生产】：不记录任何日志（默认值）。
     * BASIC【适用于生产环境追踪问题】：仅记录请求方法、URL、响应状态代码以及执行时间。
     * HEADERS：记录BASIC级别的基础上，记录请求和响应的header。
     * FULL【比较适用于开发及测试环境定位问题】：记录请求和响应的header、body和元数据。
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
