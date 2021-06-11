package com.xiaohe66.demo.arithmetic.leetcode.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T279完全平方数Test {

    private T279完全平方数 demo = new T279完全平方数();

    @Test
    public void test1() {

        assertEquals(2, demo.numSquares(2));
        assertEquals(1, demo.numSquares(1));
        assertEquals(3, demo.numSquares(8888));
        assertEquals(4, demo.numSquares(9999));
        assertEquals(1, demo.numSquares(10000));

        assertEquals(3, demo.numSquares(12));
        assertEquals(2, demo.numSquares(13));
    }

}