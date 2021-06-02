package com.xiaohe66.demo.se.designpattern.templet;

/**
 * @author xiaohe
 * @date 16-12-25 025
 *
 *
 * 模板设计模式抽象类
 * 炒菜模板
 */
public abstract class AbstractTemplate {

    /**
     * 统一炒菜模板方法，加final修辞，保证不被子类重写
     */
    public final void temlet(){
        //放油
        putDownEdibleOil();
        //下食材
        downFood();
        //下配料
        downBurdening();
        //翻炒
        roll();
        //起锅
        pot();
    }

    private void putDownEdibleOil() {
        if(isPutDownEdibleOil()){
            System.out.println("放油入锅");
        }
    }

    /**
     * 抽象方法，让子类完善
     */
    protected abstract void downFood();

    /**
     * 抽象方法，让子类完善
     */
    protected abstract void downBurdening();

    private void roll() {
        System.out.println("翻炒...");
    }

    private void pot() {
        System.out.println("起锅");
    }

    /**
     * 是否需要放油，子类可以重写该方法控制是否需要放油，默认返回true
     * 钩子方法，使模板更加灵活，可以控制某些方法是否真的需要执行。
     * @return 是否需要放油
     */
    protected boolean isPutDownEdibleOil() {
        return true;
    }
}
