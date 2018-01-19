package com.xiaohe66.demo.se.oop;

/**
 * 递归调用
 *
 * 递归调用即方法调用自己本身
 * 递归调用时需要先找到循环的规律，然后需要有出口
 *
 * 本例以求5的阶乘为例
 *
 * @author xh
 * @date 2017-12-14
 */
public class RecursionDemo {

    /**
     * 循环的方式进行阶乘运算
     * @param n
     * @return
     */
    long circulation(int n){
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result*=i;
        }
        return result;
    }

    /**
     * 递归的方式进行阶乘运算
     * @param n
     * @return
     */
    long recursion(int n){
        if(n==1){
            return 1;
        }else if(n>1){
            return recursion(n-1)*n;
        }else{
            throw new RuntimeException("输入了负数");
        }
    }

    public static void main(String[] args) {
        RecursionDemo demo = new RecursionDemo();
        System.out.println("循环方式："+demo.circulation(5));
        System.out.println("递归方式："+demo.recursion(5));
    }

}
