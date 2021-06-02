package com.xiaohe66.demo.boot.mapper;

import com.xiaohe66.demo.boot.base.BaseMapper;
import com.xiaohe66.demo.boot.pojo.Usr;
import org.apache.ibatis.annotations.Param;

public interface UsrMapper extends BaseMapper<Usr> {
    Usr queryById(@Param("id") Integer id);
    void update(Usr usr);
    void save(Usr usr);
    void delById(@Param("id") Integer id);
}