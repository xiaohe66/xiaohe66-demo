package com.xiaohe66.demo.zookeeper.lock.mapper;

import com.xiaohe66.demo.zookeeper.lock.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface OrderMapper {

    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Insert(" insert into `order`(user_id,product_id) values(#{userId},#{productId}) ")
    int insert(Order order);
}
