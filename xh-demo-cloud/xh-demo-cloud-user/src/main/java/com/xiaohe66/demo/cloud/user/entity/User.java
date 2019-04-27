package com.xiaohe66.demo.cloud.user.entity;

import lombok.Data;

/**
 * @author xiaohe
 * @date 2019.04.17 20:51
 */
@Data
public class User {

    private Integer id;
    private String name;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
