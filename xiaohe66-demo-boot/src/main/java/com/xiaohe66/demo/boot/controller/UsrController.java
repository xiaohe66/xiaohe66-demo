package com.xiaohe66.demo.boot.controller;

import com.xiaohe66.demo.boot.pojo.Usr;
import com.xiaohe66.demo.boot.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xh
 * @date 18-12-12 012
 */
@RestController
public class UsrController {

    @Autowired
    private UsrService usrService;

    @GetMapping("/usr/save")
    public String save(){
        Usr usr = new Usr();
        usr.setUsrName("小何");
        usr.setPassword("123");
        usrService.save(usr);
        return "保存成功";
    }
    @GetMapping("/usr/query")
    public String query(){
        Usr usr = usrService.queryById(1);
        return usr == null ? "无记录" : (usr.getUsrName() + "," + usr.getPassword());
    }
    @GetMapping("/usr/update")
    public String update(){
        Usr usr = new Usr();
        usr.setUsrName("xiaohe");
        usr.setPassword("456");
        usr.setId(1);
        usrService.update(usr);
        return "更新成功";
    }
    @GetMapping("/usr/del")
    public String del(){
        usrService.delById(1);

        return "删除成功";
    }

    @GetMapping("/usr/test")
    public String test(){
        usrService.test();
        return "ok";
    }


}
