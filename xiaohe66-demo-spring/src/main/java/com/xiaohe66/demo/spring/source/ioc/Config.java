package com.xiaohe66.demo.spring.source.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xiaohe
 * @time 2021.08.03 16:03
 */
@Configuration
@ComponentScan("com.xiaohe66.demo.spring.source.ioc")
@Import(TestImport.class)
public class Config {

    /*

    @Configuration 的作用
    只有被 @Configuration标记的配置类，才会被 cglib 代理。
    该配置其中的 @bean才会被代理。这样调用 @bean方法时，才会返回容器中的 bean。
    尝试：若去掉 本类的 @Configuration注解，可以看到 Car类被初始化了2次

     */

    @Bean
    public Car car() {
        return new Car();
    }

    @Bean
    public BigCar bigCar() {
        BigCar bigCar = new BigCar();
        bigCar.car = car();
        return bigCar;
    }

}
