package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class T941有效的山脉数组Test {

    T941有效的山脉数组 demo = new T941有效的山脉数组();

    @Test
    public void test1() {


        assertFalse(demo.validMountainArray(new int[]{2,1}));
        assertFalse(demo.validMountainArray(new int[]{3,5,5}));

        assertTrue(demo.validMountainArray(new int[]{0,3,2,1}));

        assertFalse(demo.validMountainArray(new int[]{0,3,2,2}));

        assertFalse(demo.validMountainArray(new int[]{3,3,2,2}));

    }

    @Test
    public void test2() {

        assertFalse(demo.validMountainArray(new int[]{14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3}));

    }
}