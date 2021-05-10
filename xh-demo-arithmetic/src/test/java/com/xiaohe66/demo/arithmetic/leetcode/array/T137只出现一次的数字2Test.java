package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T137只出现一次的数字2Test {

    private T137只出现一次的数字2 demo = new T137只出现一次的数字2();


    @Test
    public void test1() {

        assertEquals(3, demo.singleNumber(new int[]{3}));
        assertEquals(3, demo.singleNumber(new int[]{2, 2, 3, 2}));
        assertEquals(99, demo.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));

    }
}