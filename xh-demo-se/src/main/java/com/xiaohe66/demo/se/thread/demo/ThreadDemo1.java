package com.xiaohe66.demo.se.thread.demo;

/**
 * 线程安全问题
 *
 * 结论：对成员变量的操作，存在线程安全问题
 *
 * @author xh
 * @version 1.0
 * @time 2018-08-29 11:33
 */
public class ThreadDemo1 {

    private static int n = 10000;
    private String userName;
    private static int sum = 0;

    void test(String userName){
        this.userName = userName;
        String threadName = Thread.currentThread().getName();
        if(!threadName.equals(this.userName)){
            //若输出这句，则说明userName被其它线程修改了，线程不安全
            System.out.println("threadName:"+threadName+"\t-->"+this.userName);
        }
    }


    public static void main(String[] args) {
        ThreadDemo1 demo = new ThreadDemo1();
        for(int i=0;i<n;i++){
            String threadName = "user"+i;
            new Thread(threadName){
                @Override
                public void run() {
                    demo.test(threadName);
                }
            }.start();
        }

    }
}
