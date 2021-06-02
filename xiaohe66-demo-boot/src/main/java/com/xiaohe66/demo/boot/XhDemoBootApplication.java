package com.xiaohe66.demo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * MapperScan       扫描 mybatis xml包
 * ComponentScan    扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
 * EnableScheduling 开启定时任务
 * EnableAsync      开启异步
 *
 * @author xh
 */
@MapperScan(basePackages = "com.xiaohe66.demo.boot.mapper")
//@ComponentScan(basePackages= {"com.xiaohe66.demo.boot"})
@EnableScheduling
//@EnableAsync
@SpringBootApplication
public class XhDemoBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(XhDemoBootApplication.class, args);
	}

}
