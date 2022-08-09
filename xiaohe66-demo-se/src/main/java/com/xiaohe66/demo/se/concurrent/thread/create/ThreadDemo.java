package com.xiaohe66.demo.se.concurrent.thread.create;

/**
 * 使用继承的方式实现线程
 * 1.继承Thread类
 * 2.重写run方法
 * 3.创建线程
 * 4.调用线程的start方法
 *
 * @author xh
 * @date 17-12-28 028
 */
public class ThreadDemo extends Thread{

    private String name;

    ThreadDemo(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(name+"在线程中输出第："+i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo("张三");
        ThreadDemo threadDemo1 = new ThreadDemo("李四");
        threadDemo.start();
        threadDemo1.start();
    }
}
