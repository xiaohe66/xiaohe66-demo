package com.xiaohe66.demo.zookeeper.lock.entity;

/**
 * @author xiaohe66
 */
public class Order {

    private Integer id;
    private Integer productId;
    private String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
