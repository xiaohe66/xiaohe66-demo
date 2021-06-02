package com.xiaohe66.demo.se.jvm.classloader;

public class User {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void out() {
        System.out.println("我是另一个版本的User类, 加载器为:" + this.getClass().getClassLoader());
    }

}
