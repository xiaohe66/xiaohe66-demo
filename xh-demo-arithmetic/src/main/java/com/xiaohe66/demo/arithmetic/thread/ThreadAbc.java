package com.xiaohe66.demo.arithmetic.thread;

/**
 *
 * 三个线程 ABC，分别输出abc，要求同时启动线程，循环打印 abc
 *
 * @author xiaohe
 * @date 2019.04.01 17:21
 */
public class ThreadAbc{

    private static class ThreadAbc1 extends Thread{
        private String name;
        private int num;
        private final Object lock;
        private boolean isWait;
        private ThreadAbc1 next;

        private ThreadAbc1(String name, int num, boolean isWait,Object lock) {
            super(name);
            this.name = name;
            this.num = num;
            this.isWait = isWait;
            this.lock = lock;
        }

        private void setNext(ThreadAbc1 next) {
            this.next = next;
        }

        @Override
        public void run() {
            for (int i = 0; i < num; i++) {
                synchronized (lock){
                    while(isWait){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(name);
                    isWait = true;
                    next.isWait = false;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {

        Object lock = new Object();

        int num = 6;

        ThreadAbc1 a = new ThreadAbc1("a",num,false,lock);
        ThreadAbc1 b = new ThreadAbc1("b",num,true,lock);
        ThreadAbc1 c = new ThreadAbc1("c",num,true,lock);

        a.setNext(b);
        b.setNext(c);
        c.setNext(a);

        a.start();
        b.start();
        c.start();

    }
}
