package com.xiaohe66.demo.mybatis;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.xiaohe66.demo.mybatis.mapper.UserMapper;
import com.xiaohe66.demo.mybatis.model.User;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * @author xiaohe
 * @time 2019.05.30 14:33
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(true && true || true);
        System.out.println(true && false || true);
        System.out.println(false && true || true);
        System.out.println(false && false || true);
        System.out.println("----------------------------");
        System.out.println(true && true || false);
        System.out.println(false && true || false);
        System.out.println(true && false || false);
        System.out.println(false && false || false);
    }

    public void main1(String[] args) {

        String dbUrl = "jdbc:mysql://localhost:3306/xh_demo_mybatis";
        String dbUser = "root";
        String dbPwd = "root";

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUser(dbUser);
        dataSource.setPassword(dbPwd);

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.findAll());
        }


        User user = new User();

    }


}
