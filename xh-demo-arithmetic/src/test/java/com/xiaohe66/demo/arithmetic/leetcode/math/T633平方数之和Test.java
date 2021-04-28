package com.xiaohe66.demo.arithmetic.leetcode.math;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T633平方数之和Test {

    T633平方数之和 demo = new T633平方数之和();

    @Test
    public void test1() {

        assertTrue(demo.judgeSquareSum(5));
        assertTrue(demo.judgeSquareSum(4));
        assertTrue(demo.judgeSquareSum(2));
        assertTrue(demo.judgeSquareSum(1));

        assertFalse(demo.judgeSquareSum(3));
        assertTrue(demo.judgeSquareSum(0));

    }

    @Test
    public void test2() {
        assertFalse(demo.judgeSquareSum(Integer.MAX_VALUE));
    }

}