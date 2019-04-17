package com.xiaohe66.demo.boot.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author xiaohe
 * @date 2019.04.14 14:28
 */
@Component
public class XhRedisBeanPostProcessor implements BeanPostProcessor {


    /**
     * 修改 redis 序列化器
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     * @see com.xiaohe66.demo.boot.cfg.XhConfig#redisTemplate(RedisConnectionFactory)
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof RedisTemplate){
            RedisTemplate template = (RedisTemplate) bean;
            template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        }
        return bean;
    }

}
