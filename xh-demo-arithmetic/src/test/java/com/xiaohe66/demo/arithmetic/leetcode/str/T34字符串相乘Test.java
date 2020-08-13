package com.xiaohe66.demo.arithmetic.leetcode.str;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T34字符串相乘Test {

    T34字符串相乘 demo = new T34字符串相乘();

    @Test
    public void test1() {
        assertEquals("2", demo.multiply("1", "2"));
        assertEquals("0", demo.multiply("7", "0"));
        assertEquals("0", demo.multiply("0", "9"));
        assertEquals("9", demo.multiply("3", "3"));
        assertEquals("10", demo.multiply("2", "5"));
    }

    @Test
    public void test2() {
        assertEquals("231", demo.multiply("11", "21"));
        assertEquals("66", demo.multiply("11", "6"));
        assertEquals("0", demo.multiply("0", "9999"));
        assertEquals("1998", demo.multiply("999", "2"));
        assertEquals("125", demo.multiply("25", "5"));

        assertEquals("369", demo.multiply("123", "3"));
        assertEquals("199900000", demo.multiply("1999", "100000"));
        assertEquals("10000002000", demo.multiply("2", "5000001000"));
    }
}