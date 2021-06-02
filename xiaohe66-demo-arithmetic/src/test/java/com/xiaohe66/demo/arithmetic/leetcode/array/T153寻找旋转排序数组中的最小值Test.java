package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T153寻找旋转排序数组中的最小值Test {

    T153寻找旋转排序数组中的最小值 demo = new T153寻找旋转排序数组中的最小值();

    @Test
    public void test() {

        assertEquals(1, demo.findMin(new int[]{1}));

        assertEquals(1, demo.findMin(new int[]{3, 4, 5, 1, 2}));
        assertEquals(0, demo.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        assertEquals(11, demo.findMin(new int[]{11, 13, 15, 17}));


    }
}