package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class T581最短无序连续子数组Test {

    private T581最短无序连续子数组 demo = new T581最短无序连续子数组();

    @Test
    public void test1() {

        assertEquals(4,demo.findUnsortedSubarray(new int[]{27,27,28,27,103,93,115}));

        assertEquals(5,demo.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
        assertEquals(0,demo.findUnsortedSubarray(new int[]{1,2,3,4}));
        assertEquals(0,demo.findUnsortedSubarray(new int[]{1}));

    }
}