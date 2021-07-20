package com.xiaohe66.demo.arithmetic.leetcode.best;

import org.junit.Test;

import static org.junit.Assert.*;

public class T1877数组中最大数对和的最小值Test {

    private T1877数组中最大数对和的最小值 demo = new T1877数组中最大数对和的最小值();

    @Test
    public void test1() {

        assertEquals(110,demo.minPairSum(new int[]{10,30,80,90}));

        assertEquals(7,demo.minPairSum(new int[]{3,5,2,3}));
        assertEquals(8,demo.minPairSum(new int[]{3,5,4,2,4,6}));
    }
}