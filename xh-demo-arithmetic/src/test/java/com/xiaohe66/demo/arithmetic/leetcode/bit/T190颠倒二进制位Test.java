package com.xiaohe66.demo.arithmetic.leetcode.bit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T190颠倒二进制位Test {

    T190颠倒二进制位 demo = new T190颠倒二进制位();

    @Test
    public void test1() {


        assertEquals(964176192, demo.reverseBits(43261596));
        assertEquals(-1073741825, demo.reverseBits(-3));
        assertEquals(1, demo.reverseBits(Integer.MIN_VALUE));
        assertEquals(-2, demo.reverseBits(Integer.MAX_VALUE));

    }

    @Test
    public void test2() {

        assertEquals(964176192, demo.reverseBits2(43261596));
        assertEquals(-1073741825, demo.reverseBits2(-3));
        assertEquals(1, demo.reverseBits2(Integer.MIN_VALUE));
        assertEquals(-2, demo.reverseBits2(Integer.MAX_VALUE));

    }
}