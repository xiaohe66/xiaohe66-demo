package com.xiaohe66.demo.se.thread.sync;

/**
 * 引出多线程同步问题
 * 如下程序所示，在两个线程结束后，最后num的结果应该是20000
 * 但，结果并不一定是这样。
 *
 * 所以，这就是多线程操作同一个对象所产生的问题。
 *
 * 同步方式：
 * 1.代码块同步
 *      在代码块中加入sync锁
 * 2.方法同步
 *      在代方法声明时加入sync锁
 *
 * @author xh
 * @date 17-12-28 028
 */
public class SyncDemo extends Thread{

    private Obj obj;

    SyncDemo(Obj obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.print();
    }

    public static void main(String[] args) {
        Obj obj = new Obj();
        SyncDemo syncDemo1 = new SyncDemo(obj);
        SyncDemo syncDemo2 = new SyncDemo(obj);
        syncDemo1.start();
        syncDemo2.start();
    }

    static class Obj{
        private int num = 0;

        /*
        方法声明时加入sync可以使线程同步，但这样会造成其它线程更多的等待时间，
        因此能使用代码块同步的，不要使用方法同步
         */
        /*synchronized*/ void print(){
            for (int i = 0; i < 10000; i++) {
                /*
                代码块同步，放入一个对象，当前线程之间的争强对象
                只有获取到该对象的使用权时，才能进入代码块
                有一个线程进入代码块中时，其它线程不能进入
                 */
//                synchronized (Obj.class){
                    num = num + 1;
//                }
            }
            System.out.println("num结果："+num);
        }
    }
}
