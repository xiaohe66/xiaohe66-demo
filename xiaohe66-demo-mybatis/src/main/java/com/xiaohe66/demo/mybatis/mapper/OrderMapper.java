package com.xiaohe66.demo.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author xiaohe
 * @since 2022.03.04 10:35
 */
public interface OrderMapper {

    @Select("select 'order'")
    String selectOne();
}
