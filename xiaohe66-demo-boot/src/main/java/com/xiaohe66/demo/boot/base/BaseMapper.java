package com.xiaohe66.demo.boot.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author xh
 * @date 18-12-12 012
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
