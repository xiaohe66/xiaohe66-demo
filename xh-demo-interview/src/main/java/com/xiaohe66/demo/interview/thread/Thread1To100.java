package com.xiaohe66.demo.interview.thread;

/**
 *
 *
 * 编写两个线程，
 * 线程1输出100以内的单数，线程2输出100以内的双数，每个数字占一行，
 * 最终输出结果是按顺序输出1-100
 *
 * @author xiaohe
 * @date 2019.05.08 13:07
 */
public class Thread1To100 extends Thread{

    Object lock;
    int init;

    Thread1To100(Object lock,int init) {
        this.lock = lock;
        this.init = init;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            synchronized (lock){
                System.out.println(init + 2 * i);
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        new Thread1To100(lock,1).start();
        Thread.sleep(100);
        new Thread1To100(lock,2).start();

    }

}
