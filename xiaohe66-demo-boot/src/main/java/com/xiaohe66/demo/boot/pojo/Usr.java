package com.xiaohe66.demo.boot.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Usr {
    @Id
    private Integer id;

    @Column(name = "usr_name")
    private String usrName;

    private String password;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return usr_name
     */
    public String getUsrName() {
        return usrName;
    }

    /**
     * @param usrName
     */
    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}