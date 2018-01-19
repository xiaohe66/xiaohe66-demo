package com.xiaohe66.demo.se.oop.perm;

/**
 * java的访问控制权限修饰符，可作用于属性或方法
 *
 * 而package和protected比较有歧义
 * 分别看test和test2包下的PermTestSon类以作对比
 *
 * 经过实验，得出以下结论：
 * 1、public     全局，可在任何地方访问
 * 2、private    私有，只能在当前类中访问
 * 3、protected  在不同包的子类中可访问
 * 4、package    在不同包的子类中不可以访问
 *
 *
 * 可见/访问性	在同一类中	同一包中	同一包子类中 	不同包子类中	不同包中
 *  public	     yes	     yes	 yes	      yes	      yes
 *  protected 	 yes	     yes	 yes	      yes	      no
 *  package 	 yes	     yes	 yes	      no	      no
 *  private	     yes	     no	     no	          no	      no
 *
 * @author xh
 * @date 2017-12-13
 */
public class PermDemo {
    private int a1;
    protected int a3;
    /**
     * 不写访问权限，就是包访问权限。即默认为包访问权限
     */
    int a2;
    public int a4;

    /**
     * 作用于构造方法
     */
    public PermDemo(){

    }

    /**
     * 作用于普通方法
     */
    public void fun(){

    }
}
