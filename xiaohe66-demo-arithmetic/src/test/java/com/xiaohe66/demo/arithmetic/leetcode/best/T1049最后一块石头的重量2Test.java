package com.xiaohe66.demo.arithmetic.leetcode.best;

import org.junit.Test;

import static org.junit.Assert.*;

public class T1049最后一块石头的重量2Test {

    private T1049最后一块石头的重量2 demo = new T1049最后一块石头的重量2();

    @Test
    public void test1() {

        assertEquals(5,demo.lastStoneWeightII(new int[]{6,1}));
        assertEquals(0,demo.lastStoneWeightII(new int[]{1,1}));
        assertEquals(6,demo.lastStoneWeightII(new int[]{6}));
        assertEquals(2,demo.lastStoneWeightII(new int[]{2}));
        assertEquals(1,demo.lastStoneWeightII(new int[]{1}));

        assertEquals(1,demo.lastStoneWeightII(new int[]{2,7,4,1,8,1}));
        assertEquals(5,demo.lastStoneWeightII(new int[]{31,26,33,21,40}));
        assertEquals(1,demo.lastStoneWeightII(new int[]{1,2}));
    }
}