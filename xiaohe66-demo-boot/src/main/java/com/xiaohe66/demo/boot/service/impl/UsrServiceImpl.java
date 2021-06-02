package com.xiaohe66.demo.boot.service.impl;

import com.xiaohe66.demo.boot.mapper.UsrMapper;
import com.xiaohe66.demo.boot.pojo.Usr;
import com.xiaohe66.demo.boot.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xh
 */
@Service
public class UsrServiceImpl implements UsrService {

    @Autowired
    private UsrMapper usrMapper;

    @Autowired
    public UsrServiceImpl(UsrMapper usrMapper) {
        this.usrMapper = usrMapper;
    }

    @Override
    public Usr queryById(Integer id) {
        return usrMapper.queryById(id);
    }

    @Override
    public void update(Usr usr) {
        usrMapper.update(usr);
    }

    @Override
    public void save(Usr usr) {
        usrMapper.save(usr);
    }

    @Override
    public void delById(Integer id) {
        usrMapper.delById(id);
    }


    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void test() {
        Usr usr = new Usr();
        usr.setUsrName("xh");
        usr.setPassword("111");

        usrMapper.insert(usr);

        int a = 1/0;

        System.out.println(a);

        usr.setUsrName("何少");
        usr.setPassword("22");
        usrMapper.update(usr);
    }
}
