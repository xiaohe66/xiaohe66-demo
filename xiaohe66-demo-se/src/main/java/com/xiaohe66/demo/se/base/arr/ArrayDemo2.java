package com.xiaohe66.demo.se.base.arr;

/**
 * @author xh
 * @date 2017-12-11
 */
public class ArrayDemo2 {
    public static void main(String[] args) {
        int[][] arr2 = new int[][]{{1,2,3,},{4,5,6},{7,8,9}};
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                System.out.print(arr2[i][j]);
            }
            System.out.println();
        }
    }
}
