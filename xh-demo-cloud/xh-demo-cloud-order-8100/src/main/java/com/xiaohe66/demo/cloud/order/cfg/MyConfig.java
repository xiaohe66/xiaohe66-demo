package com.xiaohe66.demo.cloud.order.cfg;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaohe
 * @date 2019.04.17 20:41
 */
@Configuration
public class MyConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 修改 RestTemplate 调用服务的轮询器
     */
//    @Bean
    public IRule myRule(){
        return new XhRule();
    }


    /**
     * 加上这个配置，用于开启 hystrix 监控
     *
     * note : F 版本之前，不用加上该配置，也是默认开启的
     *
     */
    @Bean
    public ServletRegistrationBean getServlet(){

        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);  //系统启动时加载顺序
        registrationBean.addUrlMappings("/actuator/hystrix.stream");//路径
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
