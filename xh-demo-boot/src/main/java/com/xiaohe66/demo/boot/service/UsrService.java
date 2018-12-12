package com.xiaohe66.demo.boot.service;

import com.xiaohe66.demo.boot.pojo.Usr;

/**
 * @author xh
 * @date 18-12-12 012
 */
public interface UsrService {

    Usr queryById(Integer id);
    void update(Usr usr);
    void save(Usr usr);
    void delById(Integer id);

    void test();

}
