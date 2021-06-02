package com.xiaohe66.demo.se.base.arr;

/**
 * @author xh
 * @date 2017-12-11
 */
public class ArrayDemo {
    /**
     * 静态初始化
     */
    public static void staticInit(){
        System.out.println("静态初始化------------");
        int[] arr = new int[]{1,2,3};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void dynamicInit(){
        System.out.println("动态初始化------------");
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        staticInit();
        dynamicInit();
    }
}
