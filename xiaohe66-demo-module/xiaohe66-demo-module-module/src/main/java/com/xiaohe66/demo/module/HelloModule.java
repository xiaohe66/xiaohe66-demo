package com.xiaohe66.demo.module;

import com.xiaohe66.demo.module.impl.HelloModuleImpl;

/**
 * @author xiaohe
 * @since 2021.10.13 11:16
 */
public interface HelloModule {

    void hello();

    static HelloModule getInstance() {
        return new HelloModuleImpl();
    }

}
