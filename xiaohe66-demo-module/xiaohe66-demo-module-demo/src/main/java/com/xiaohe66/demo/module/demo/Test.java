package com.xiaohe66.demo.module.demo;


import com.xiaohe66.demo.module.HelloModule;

/**
 * @author xiaohe
 * @since 2021.10.13 11:18
 */
public class Test {


    public static void main(String[] args) {

        // 通过开放的包，访问私有的实现类。
        // 由于未开放 impl包，因此无法访问 HelloModuleImpl 类
        HelloModule.getInstance().hello();
    }

}
