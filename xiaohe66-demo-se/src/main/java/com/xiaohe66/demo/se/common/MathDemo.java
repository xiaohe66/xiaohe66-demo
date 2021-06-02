package com.xiaohe66.demo.se.common;

/**
 * 数学运算类
 * 其中封装了大多数数据运算的方法
 *
 * @author xh
 * @date 17-12-20 020
 */
public class MathDemo {

    public static void main(String[] args) {
        //求最大值
        System.out.println("最大值："+Math.max(1,2));
        //求最小值
        System.out.println("最小值："+Math.min(1,2));
        //四舍五入
        System.out.println("四舍五入："+Math.round(4.4));
        System.out.println("四舍五入："+Math.round(5.5));
        //求次方
        System.out.println("3的四次方："+Math.pow(3,4));
    }
}
