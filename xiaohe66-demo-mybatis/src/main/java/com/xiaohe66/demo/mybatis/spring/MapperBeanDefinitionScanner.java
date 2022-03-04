package com.xiaohe66.demo.mybatis.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * @author xiaohe
 * @since 2022.03.04 10:02
 */
@Slf4j
public class MapperBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

    public MapperBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);

        for (BeanDefinitionHolder holder : beanDefinitionHolders) {

            log.info("scan : {}", holder.getBeanName());

            BeanDefinition beanDefinition = holder.getBeanDefinition();

            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            beanDefinition.setBeanClassName(MyMapperFactoryBean.class.getName());
        }

        return beanDefinitionHolders;
    }



    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {

        // 扫描接口，判断如果是接口，则返回true
        return beanDefinition.getMetadata().isInterface();
    }
}
