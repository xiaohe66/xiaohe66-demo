package com.xiaohe66.demo.mybatis.spring;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author xiaohe
 * @since 2022.03.04 09:58
 */
@RequiredArgsConstructor
@Slf4j
public class MyMapperFactoryBean implements FactoryBean<Object> {

    private final Class<?> interfaceClass;

    private SqlSession sqlSession;

    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(interfaceClass);
        this.sqlSession = sqlSessionFactory.openSession();
    }

    @Override
    public Object getObject() throws Exception {

        return sqlSession.getMapper(interfaceClass);
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }
}
