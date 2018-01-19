package com.xiaohe66.demo.se.base.control;

/**
 * @author xh
 * @date 2017-12-10
 *
 * 循环控制语句
 */
public class Circulation {

    /**
     * while
     * 条件判断结果为true时，会一直执行，直至条件结果为false
     */
    public static void whileDemo(){
        int i=0;
        while(i<=5){
            System.out.println("whileDemo,i="+i);
            i++;
        }
    }

    /**
     * do……while和while类似，
     * 不同的是会先执行do里面的内容，再执行条件判断
     */
    public static void doWhileDemo(){
        int j=0;
        while (j<0){
            System.out.println("while输出,j="+j);
        }
        int i=0;
        do {
            System.out.println("doWhile输出,i="+i);
            i++;
        }while (i<0);
    }

    /**
     * for
     * for(开始时的操作；条件；每步循环结束后的操作)
     * for循环非常适用于已经起点和终点的循环体
     */
    public static void forDemo(){
        for (int i=0;i<5;i++){
            System.out.println("forDemo,i="+i);
        }
    }

    public static void main(String[] args) {
        whileDemo();
        doWhileDemo();
        forDemo();
    }

}
