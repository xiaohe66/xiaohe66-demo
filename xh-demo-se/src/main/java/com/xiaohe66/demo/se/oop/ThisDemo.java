package com.xiaohe66.demo.se.oop;

/**
 * @author xh
 * @date 2017-12-14
 *
 * java中this关键字
 *
 * this指当前对象
 * 一般用到this的是成员变量的赋值、构造函数的调用
 */
public class ThisDemo {

    private String msg;

    ThisDemo(){
        System.out.println("无参构造方法");
    }

    /**
     * 一般的，无参的构造方法会进行最基础的初始化
     * 但是，有些时候，在完成对成员变量的初始化之后，需要调用默认的构造函数进行初始化
     *
     * 使用this关键字进行构造函数与构造函数之间的调用
     * @param msg
     */
    ThisDemo(String msg){
        //调用无参构造函数
        this();
        System.out.println(this.msg);
        //使用this关键字让相同的参数名进行赋值操作
        this.msg = msg;
        System.out.println("有参构造方法,msg="+msg);
    }

    public void say(){
        System.out.println("msg="+msg);
    }
    public static void main(String[] args) {
        new ThisDemo("消息").say();
    }


}
