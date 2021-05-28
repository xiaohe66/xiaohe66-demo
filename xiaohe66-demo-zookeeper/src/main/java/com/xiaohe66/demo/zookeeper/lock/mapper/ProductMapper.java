package com.xiaohe66.demo.zookeeper.lock.mapper;

import com.xiaohe66.demo.zookeeper.lock.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface ProductMapper {

    @Select(" select * from product where id=#{id}  ")
    Product getProduct(@Param("id") Integer id);

    @Update(" update product set stock = stock-1    where id=#{id}  ")
    int deductStock(@Param("id") Integer id);
}
