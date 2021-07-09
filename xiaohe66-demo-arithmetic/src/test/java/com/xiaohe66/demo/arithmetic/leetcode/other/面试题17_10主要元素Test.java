package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class 面试题17_10主要元素Test {

    private 面试题17_10主要元素 demo = new 面试题17_10主要元素();

    @Test
    public void test1() {

        assertEquals(-1, demo.majorityElement(new int[]{}));
        assertEquals(2, demo.majorityElement(new int[]{2}));
        assertEquals(2, demo.majorityElement(new int[]{2, 2}));
        assertEquals(2, demo.majorityElement(new int[]{2, 2, 1}));
        assertEquals(2, demo.majorityElement(new int[]{1, 2, 2}));
        assertEquals(2, demo.majorityElement(new int[]{2, 1, 2}));
        assertEquals(-1, demo.majorityElement(new int[]{2, 2, 1, 1}));
        assertEquals(1, demo.majorityElement(new int[]{2, 2, 1, 1, 1}));

        assertEquals(5, demo.majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
        assertEquals(-1, demo.majorityElement(new int[]{3, 2}));
        assertEquals(2, demo.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));


    }
}