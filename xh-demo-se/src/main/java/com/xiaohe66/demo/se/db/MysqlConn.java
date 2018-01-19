package com.xiaohe66.demo.se.db;

import java.sql.*;

/**
 * @author xiaohe
 * @date 17-09-13 013
 */
public class MysqlConn {

    private static final String MYSQL_URL = "db:mysql://localhost:3306/xh_web";
    private static final String USER_NAME = "root";
    private static final String PWD = "xiaohe73";

    public void query(){
        Connection connection = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.db.Driver");
            //2.创建数据库连接
            connection = DriverManager.getConnection(MYSQL_URL,USER_NAME,PWD);
            //3.创建statement对象
             Statement statement = connection.createStatement();
            //4.执行sql
            ResultSet resultSet = statement.executeQuery("select * from xh_org_user;");
            //5.遍历结果
            while (resultSet.next()){
                String userName = resultSet.getString("user_name");
                String userPwd = resultSet.getString("user_pwd");
                System.out.println("userName:"+userName + ",userPwd:" + userPwd);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void query2(){
        Connection connection = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.db.Driver");
            //2.创建数据库连接
            connection = DriverManager.getConnection(MYSQL_URL,USER_NAME,PWD);
            //3.创建preparedStatement对象
            String sql = "select * from xh_org_user where user_name = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //4.设置参数
            preparedStatement.setString(1,"xiaohe");
            //5.执行sql
            preparedStatement.execute();
            //6.遍历结果
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                String userName = resultSet.getString("user_name");
                String userPwd = resultSet.getString("user_pwd");
                System.out.println("userName:"+userName + ",userPwd:" + userPwd);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public static void main(String[] args) {
        new MysqlConn().query2();
    }

}
