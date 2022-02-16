package com.xiaohe66.demo.cloud2.user.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * feign 拦截器
 * 在调用执行前调用，可用该拦截器实现认证、添加等统一参数的修改
 *
 * Interceptor
 * 英 [ˌɪntəˈseptə(r)]  发音{in te(拼音)色扑特}
 *
 * @author xiaohe
 * @since 2022.02.17 11:44
 */
@Slf4j
@Component
public class FeignAuthRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {

        log.info("feign 请求拦截器被执行");
        log.info("url : {}", requestTemplate.url());
        log.info("origin header : {}", requestTemplate.headers());

        requestTemplate.header("my_header","my_value");
    }
}
