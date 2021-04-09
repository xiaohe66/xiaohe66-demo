package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class T154寻找旋转排序数组中的最小值2Test {

    T154寻找旋转排序数组中的最小值2 demo = new T154寻找旋转排序数组中的最小值2();

    @Test
    public void test1() {

        assertEquals(1,demo.findMin(new int[]{3,5,1}));

        assertEquals(0,demo.findMin(new int[]{2,2,2,0,1}));
        assertEquals(1,demo.findMin(new int[]{1,3,5}));

        assertEquals(4,demo.findMin(new int[]{4,4}));
        assertEquals(3,demo.findMin(new int[]{3,4}));
        assertEquals(3,demo.findMin(new int[]{4,3}));
        assertEquals(3,demo.findMin(new int[]{4,3,4,4}));
        assertEquals(3,demo.findMin(new int[]{4,4,3,4}));


    }
}