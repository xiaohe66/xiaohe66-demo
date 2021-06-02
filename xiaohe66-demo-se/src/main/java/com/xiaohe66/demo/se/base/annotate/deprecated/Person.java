package com.xiaohe66.demo.se.base.annotate.deprecated;

/**
 * @author xh
 * @date 2017-12-8
 */
public interface Person {
    /**
     * 获取名称
     * @return 名称
     */
    String getName();

    /**
     * 这是唱歌方法，不一定所有人都会，所以要删除该方法，但又有可能还有人在用。
     * 所以，要删除该方法，但又不能删除这个方法时
     * 可以使用@Deprecated注解来表示该方法已经过时。
     */
    @Deprecated
    void sing();
}
