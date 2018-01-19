package com.xiaohe66.demo.se.designpattern.templet;

/**
 * @author xiaohe
 * @date 16-12-25 025
 *
 * 模板设计模板
 * 定义：
 * 实现过程：
 * 1、构建模板抽象类，提供统一的public模板方法，并加final修辞，使其不能被子类重写
 * 2、在模板抽象类中定义基础的模板步骤，将不会改变的步骤加private修辞，使其不能被子类重写，且不可见。
 * 3、在模板抽象类中将一些可变的步骤定义为抽象方法，让子类实现，以完善步骤。
 * 4、子类继承模板抽象类，并实现模板类中的抽象方法，完善步骤。
 * 5、最后在使用时，直接调用模板中的公用方法即可。
 * 6、可以加钩子方法，使整个模板更加灵活。
 */
public class TemplateTest {

    public static void main(String[] args){
        //模板炒菜的实现类 ——>炒青菜测试
        AbstractTemplate template1 = new Template1();
        template1.temlet();
        System.out.println("---------------------------------------");
        //模板炒菜的实现类 ——>炒肉测试
        AbstractTemplate template2 = new Template2();
        template2.temlet();
    }
}
