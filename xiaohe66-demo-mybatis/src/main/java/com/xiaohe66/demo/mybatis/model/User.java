package com.xiaohe66.demo.mybatis.model;

/**
 * @author xiaohe
 * @time 2019.05.30 14:39
 */
public class User {

    private Integer id;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "{" + "\"id\":\"" + id + "\""
                + ",\"userName\":\"" + userName + "\""
                + "}";
    }
}
