package com.xiaohe66.demo.mybatis.mapper;

import com.xiaohe66.demo.mybatis.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xiaohe
 * @since 2019.05.30 14:40
 */
public interface UserMapper {

    @Select("select 'user'")
    String selectOne();

    @Select("select id,`name`, `name` as nameInt from `user`")
    List<User> findAll();

}
