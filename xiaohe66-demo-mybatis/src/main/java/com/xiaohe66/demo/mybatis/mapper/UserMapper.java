package com.xiaohe66.demo.mybatis.mapper;

import com.xiaohe66.demo.mybatis.model.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author xiaohe
 * @time 2019.05.30 14:40
 */
public interface UserMapper {

    @Select("select id,user_name as userName from `user`")
    User findAll();

}
