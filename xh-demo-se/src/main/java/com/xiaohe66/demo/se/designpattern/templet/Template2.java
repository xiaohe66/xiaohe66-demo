package com.xiaohe66.demo.se.designpattern.templet;

/**
 *
 * @author xiaohe
 * @date 16-12-26 026
 *
 * 模板设计模式
 * 炒菜实现类 ——>炒肉
 */
public class Template2 extends AbstractTemplate {

    /**
     * 实现模板方法中的下食材方法
     */
    @Override
    protected void downFood() {
        System.out.println("放肉入锅");
    }

    /**
     * 实现模板方法中的下配料方法
     */
    @Override
    protected void downBurdening() {
        System.out.println("加入酱油");
    }

    /**
     * 重写父类的钩子方法，可以达到控制程序的目的
     * @return 是否需要放油
     */
    @Override
    protected boolean isPutDownEdibleOil() {
        return false;
    }
}
