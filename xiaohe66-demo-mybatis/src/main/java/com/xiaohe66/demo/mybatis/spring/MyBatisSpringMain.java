package com.xiaohe66.demo.mybatis.spring;

import com.xiaohe66.demo.mybatis.SqlSessionFactoryHolder;
import com.xiaohe66.demo.mybatis.mapper.OrderMapper;
import com.xiaohe66.demo.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 自编写 Spring 整合 MyBatis
 *
 * <p>
 * 整合的关键，就是将 MyBatis生成的代理对象放到 Spring 容器中，使其成为一个 Bean,
 * 使用 FactoryBean可以很好的解决这个问题
 *
 * @author xiaohe
 * @since 2022.03.04 10:30
 */
@MyMapperScan("com.xiaohe66.demo.mybatis.mapper")
public class MyBatisSpringMain {

    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        return SqlSessionFactoryHolder.get();
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyBatisSpringMain.class);

        UserMapper userMapper = context.getBean(UserMapper.class);
        OrderMapper orderMapper = context.getBean(OrderMapper.class);

        System.out.println(userMapper.selectOne());
        System.out.println(orderMapper.selectOne());
    }

}
