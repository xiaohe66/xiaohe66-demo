package com.xiaohe66.demo.spring.diy.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 自定义controller
 *
 * @author xh
 * @date 2017/10/30
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyController {
    String value() default "";
}