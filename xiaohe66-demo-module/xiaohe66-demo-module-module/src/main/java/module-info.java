/**
 * 模块名：不能以数字结尾，但可以把数字放在中间。我：表面笑嘻嘻，内心 MMP（xiaohe66）
 */
module xiaohe.demo.module.module {

    /*
     * 模块开放了 test1包，但未开放 impl包，
     * 因此外部不能访问 {@link com.xiaohe66.module.test1.impl.HelloModuleImpl}
     */
    exports com.xiaohe66.demo.module;

}