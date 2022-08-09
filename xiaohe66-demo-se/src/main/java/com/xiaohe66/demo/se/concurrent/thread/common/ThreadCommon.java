package com.xiaohe66.demo.se.concurrent.thread.common;

/**
 * @author xh
 * @date 17-12-29 029
 */
public class ThreadCommon extends Thread{

    public ThreadCommon(String name){
        super(name);
    }
    @Override
    public void run() {
        System.out.println("我是一个线程，我的名字是："+getName());
//        currentThread()获取当前线程的引用
        System.out.println("我是一个线程，我的名字是："+currentThread().getName());

        System.out.println("线程是否活动"+isAlive());

        System.out.println("线程休眠开始");
        //线程休眠，需要捕获异常
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程休眠结束");

        //暂停线程--》让出cpu给别的线程
        yield();
    }

    public static void main(String[] args) {
        Thread thread1 = new ThreadCommon("线程1");
        //设置线程的优先级，取值：1-10
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
    }
}
