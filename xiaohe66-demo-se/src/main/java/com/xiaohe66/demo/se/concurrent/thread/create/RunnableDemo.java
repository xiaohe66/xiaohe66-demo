package com.xiaohe66.demo.se.concurrent.thread.create;

/**
 * 使用实现接口的方式创建线程
 * 1.实现Runnable接口
 * 2.实现Run方法
 * 3.创建Thread对象，把实现Runnable接口的对象传入
 * 4.调用Thread对象的start方法
 *
 * @author xh
 * @date 17-12-28 028
 */
public class RunnableDemo implements Runnable{
    private String name;

    RunnableDemo(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(name+"在线程中输出第："+i);
        }
    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo("张三");
        RunnableDemo runnableDemo1 = new RunnableDemo("李四");
        Thread thread1 = new Thread(runnableDemo);
        Thread thread2 = new Thread(runnableDemo1);

        thread1.start();
        thread2.start();
    }
}
