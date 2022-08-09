package com.xiaohe66.demo.se.concurrent.thread.demo;


/**
 * 线程安全问题
 *
 * 结论：i++/i--/++i/--i 都是线程不安全的
 *
 * @author xh
 * @version 1.0
 * @time 2018-09-05 16:39
 */
public class ThreadDemo2 {

    static int i;


    public static void main(String[] args) {
        int n=100000;
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < n; j++){
                i++;
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int j = 0; j < n; j++){
                i++;
            }
        });
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //若输出的结果不是 n的2倍，则说明不是线程安全
        System.out.println("i="+i);


    }
}
