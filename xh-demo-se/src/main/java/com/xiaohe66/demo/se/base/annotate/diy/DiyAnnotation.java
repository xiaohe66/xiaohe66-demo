package com.xiaohe66.demo.se.base.annotate.diy;

import java.lang.annotation.*;

/**
 * Created by xiaohe on 16-12-20 020.
 *
 * 自定义注解
 * 当成员只有一个时，习惯把成员名定义为value。
 * 成员的数量也可以为0，这时该注解只定到标识的作用。
 */
@Target(ElementType.TYPE)//定义该注解的作用域
@Retention(RetentionPolicy.RUNTIME)//定义该注解的生命周期
@Inherited//允许子类继承
@Documented//可以在javadoc中生成
public @interface DiyAnnotation {

    //成员，必须要使用无参无异常的方式声明，并且只能使用基本数据类型
    String desc();

    //可以使用default给参数指定默认值
    String value() default "";
}