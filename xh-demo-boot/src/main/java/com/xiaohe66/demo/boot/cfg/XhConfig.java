package com.xiaohe66.demo.boot.cfg;


import com.xiaohe66.demo.boot.filter.TestFilter;
import com.xiaohe66.demo.boot.interceptor.TestInterceptor;
import com.xiaohe66.demo.boot.servlet.TestServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义配置
 *
 * @author xiaohe
 * @date 2019.04.12 11:23
 */
@Configuration
public class XhConfig implements WebMvcConfigurer {

    @Autowired
    private TestInterceptor testInterceptor;

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html","/");
    }

    /**
     * 注册一个过虑器
     * @return
     */
    @Bean
    public FilterRegistrationBean registerFilter(){
        FilterRegistrationBean<TestFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new TestFilter());
        filterRegistrationBean.addUrlPatterns("/");
        return filterRegistrationBean;
    }

    /**
     * 注册一个 servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean<TestServlet> registerServlet(){
        ServletRegistrationBean<TestServlet> servletServletRegistrationBean = new ServletRegistrationBean<>();
        servletServletRegistrationBean.addUrlMappings("/testServlet");
        servletServletRegistrationBean.setServlet(new TestServlet());
        return servletServletRegistrationBean;
    }

    /**
     * 自定义 redis 序列化器
     * @return
     * @see com.xiaohe66.demo.boot.processor.XhRedisBeanPostProcessor#postProcessAfterInitialization(Object, String)
     */
//    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
		RedisTemplate<Object, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
		return template;
	}

}
