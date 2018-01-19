package com.xiaohe66.demo.se.reflect;

/**
 * 反射，可以通过对象操作类
 *
 * 关键类：java.lang.Class
 * 本例演示获取Class的几种方式，和通过反射创建实例
 *
 *
 * @author xh
 * @date 17-12-20 020
 */
public class ReflectClassDemo {

    /**
     * 获取Class对象的3种方式
     * Class实例的getName可以获取Class对象的全类名
     */
    void getClassDemo(){
        //1.通过对象的getClass方法
        String str = "";
        Class cls1 = str.getClass();
        System.out.println(cls1.getName());
        //2.通过类名.class
        Class cls2 = String.class;
        System.out.println(cls2.getName());

        try {
            //3.通过全包名
            Class cls3 = Class.forName("java.lang.String");
            System.out.println(cls2.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过反射创建实例
     */
    void newInstance(){
        //1.获取class对象
        Class cls = MyClass.class;
        MyClass myClass = null;
        try {
            //2.通过newInstance()方法实例化对象，创建的对象是Object类型
            myClass = (MyClass) cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        myClass.func4();
    }


    public static void main(String[] args) {
        ReflectClassDemo classDemo = new ReflectClassDemo();
        classDemo.getClassDemo();
        classDemo.newInstance();
    }
}
