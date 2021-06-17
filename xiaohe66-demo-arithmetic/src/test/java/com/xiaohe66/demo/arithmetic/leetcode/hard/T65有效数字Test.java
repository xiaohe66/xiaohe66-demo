package com.xiaohe66.demo.arithmetic.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class T65有效数字Test {

    private T65有效数字 demo = new T65有效数字();

    @Test
    public void test1() {

        assertFalse(demo.isNumber("6e6.5"));

        assertTrue(demo.isNumber("3."));
        assertTrue(demo.isNumber("+3."));
        assertTrue(demo.isNumber("+.3"));
        assertTrue(demo.isNumber("+3.3"));
        assertFalse(demo.isNumber("+."));
        assertFalse(demo.isNumber("+123.e"));

        assertFalse(demo.isNumber("+.0e5122-a"));

        assertTrue(demo.isNumber("+.0e5122"));
        assertTrue(demo.isNumber("+0.0e5122"));

        assertFalse(demo.isNumber("+0.0e-512e2"));
        assertTrue(demo.isNumber("+0.0e-5122"));
        assertTrue(demo.isNumber("+0.0e-51"));
        assertTrue(demo.isNumber("+.0e-51"));

        assertFalse(demo.isNumber("+0.0e-5.12e2"));
        assertFalse(demo.isNumber("+0.0e-5.122"));
        assertFalse(demo.isNumber("+0.0e-5.1"));
        assertFalse(demo.isNumber("+.0e-5.1"));
        assertTrue(demo.isNumber("-.0"));

        assertTrue(demo.isNumber("+.0"));
        assertTrue(demo.isNumber("-.0"));

        assertTrue(demo.isNumber("+0"));
        assertTrue(demo.isNumber("-0"));

        assertTrue(demo.isNumber("0"));
        assertFalse(demo.isNumber("e"));
        assertFalse(demo.isNumber("."));
        assertTrue(demo.isNumber(".1"));


    }
}