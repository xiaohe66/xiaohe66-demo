package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T136只出现一次的数字Test {

    T136只出现一次的数字 demo = new T136只出现一次的数字();

    @Test
    public void test1() {

        assertEquals(2, demo.singleNumber(new int[]{2}));
        assertEquals(1, demo.singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, demo.singleNumber(new int[]{4, 1, 2, 1, 2}));

    }
}