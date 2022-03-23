package com.xiaohe66.demo.mybatis;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.xiaohe66.demo.mybatis.config.StringToIntegerTypeHandler;
import com.xiaohe66.demo.mybatis.mapper.UserMapper;
import com.xiaohe66.demo.mybatis.model.User;
import com.xiaohe66.demo.mybatis.plugin.UpdateLogPlugin;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.junit.Test;

/**
 * @author xiaohe
 * @since 2022.03.03 17:53
 */
@Slf4j
public class MyBatisTest {

    @Test
    public void test1() {

        String dbUrl = "jdbc:mysql://localhost:3306/test";
        String dbUser = "root";
        String dbPwd = "root";

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUser(dbUser);
        dataSource.setPassword(dbPwd);

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);

        Configuration configuration = new Configuration(environment);
        configuration.addInterceptor(new UpdateLogPlugin());
        configuration.addMapper(UserMapper.class);

        // TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
        // typeHandlerRegistry.register(new StringToIntegerTypeHandler());

        // configuration.setDefaultEnumTypeHandler(StringToIntegerTypeHandler.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            log.info(userMapper.selectOne());

            log.info("-------------");
            userMapper.update(1);
            log.info("-------------");
        }

    }
}
