package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

public class T57插入区间Test {

    T57插入区间 demo = new T57插入区间();

    @Test
    public void test1() {
        int[][] ret;
        ret = demo.insert(new int[][]{
                {1, 3},
                {6, 9},
        }, new int[]{2, 5});

        outArr(ret);

        ret = demo.insert(new int[][]{
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        }, new int[]{4, 8});

        outArr(ret);

        //assertArrayEquals(null,null);
    }

    private void outArr(int[][] ret) {
        System.out.print('[');
        for (int[] arr : ret) {
            System.out.print('[');
            for (int i : arr) {
                System.out.print(i);
                System.out.print(',');
            }
            System.out.print(']');
        }
        System.out.println(']');
    }
}