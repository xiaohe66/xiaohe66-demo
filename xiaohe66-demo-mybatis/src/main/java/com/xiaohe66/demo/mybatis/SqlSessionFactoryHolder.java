package com.xiaohe66.demo.mybatis;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.xiaohe66.demo.mybatis.mapper.UserMapper;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * @author xiaohe
 * @since 2022.03.04 10:43
 */
public final class SqlSessionFactoryHolder {

    public static SqlSessionFactory get() {

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

        return new SqlSessionFactoryBuilder().build(configuration);
    }

}
