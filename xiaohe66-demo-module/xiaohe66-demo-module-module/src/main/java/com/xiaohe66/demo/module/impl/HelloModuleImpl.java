package com.xiaohe66.demo.module.impl;

import com.xiaohe66.demo.module.HelloModule;

/**
 * @author xiaohe
 * @since 2021.10.13 11:24
 */
public class HelloModuleImpl implements HelloModule {

    @Override
    public void hello() {
        System.out.println("hello module");
    }
}
