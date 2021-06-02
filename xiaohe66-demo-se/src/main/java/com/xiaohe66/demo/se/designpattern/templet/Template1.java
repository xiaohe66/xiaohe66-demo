package com.xiaohe66.demo.se.designpattern.templet;

/**
 * @author xiaohe
 * @date 16-12-26 026
 *
 * 模板设计模式
 * 炒菜实现类 ——>炒青菜
 */
public class Template1 extends AbstractTemplate {

    /**
     * 实现模板方法中的下食材方法
     */
    @Override
    protected void downFood() {
        System.out.println("放入青菜");
    }

    /**
     * 实现模板方法中的下配料方法
     */
    @Override
    protected void downBurdening() {
        System.out.println("加入盐");
    }

}
