package com.xiaohe66.demo.se.concurrent.thread.state;

/**
 * 线程的状态
 *
 * 1.创建
 *      调用构造方法创建线程后，新的线程对象就处于“创建”状态。
 *      如：<code>Thread thread = new Thread();</code>
 *      但是，此时该线程还处于不可运行状态。
 * 2.就绪
 *      新建线程后，调用该线程的start方法后，就会启动该线程。
 *      但是，该线程并不会立即执行，而是进入就绪状态。
 *      进入就绪状态后，该线程将进入线程队列排队，等待cpu的调度。
 * 3.运行
 *      当就绪状态的线程被cpu调度后，线程就进入了运行状态。会自动调用线程的run()方法
 * 4.阻塞
 *      一个处于运行状态的线程，在遇到某些特殊情况时，会进入阻塞状态。
 *      如：人为挂起/执行耗时的输入输出操作时
 *      线程会让出cpu并暂时中止自己的执行，进入阻塞状态。
 *      阻塞的状态不能进入排队队列，只有当引起阻塞的原因消除后，线程才可以进入就绪状态。
 * 5.消亡
 *      当一个线程stop()方法，或run()方法运行完成后，就进入了消亡状态。
 *
 * @author xh
 * @date 17-12-29 029
 */
public class ThreadStateDemo extends Thread{

    @Override
    public void run() {
        //3.进入就绪状态的线程，得到cpu的调用后，进入运行状态，自己调用run方法
        System.out.println("线程处于运行状态");
        //4.因人为原因，使线程进入阻塞状态
        try {
            //人为使线程睡眠1秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //5.经过1秒的睡眠后，线程重新进行就绪状态
        //6.得到cpu的调度后，线程继续执行
        System.out.println("线程重新进入运行状态");
        //7.线程的run方法执行完成后，线程消亡
    }

    public static void main(String[] args) {
        //1.创建一个线程，此时线程处于创建状态
        Thread thread = new ThreadStateDemo();
        //2.调用线程的start方法，调用后，线程进行就绪状态
        thread.start();
    }

}
