package com.xiaohe66.demo.arithmetic.leetcode.bit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T191位1的个数Test {


    T191位1的个数 demo = new T191位1的个数();

    @Test
    public void test1() {


        assertEquals(3, demo.hammingWeight(11));


        assertEquals(31, demo.hammingWeight(-3));

        assertEquals(31, demo.hammingWeight(Integer.MAX_VALUE));
        assertEquals(1, demo.hammingWeight(Integer.MIN_VALUE));

        assertEquals(16, demo.hammingWeight(-1431655766));


    }
}