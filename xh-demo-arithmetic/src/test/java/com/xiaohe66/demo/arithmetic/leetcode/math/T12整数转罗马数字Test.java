package com.xiaohe66.demo.arithmetic.leetcode.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class T12整数转罗马数字Test {

    T12整数转罗马数字 demo = new T12整数转罗马数字();

    @Test
    public void test1() {

        assertEquals("III",demo.intToRoman(3));
        assertEquals("IV",demo.intToRoman(4));
        assertEquals("IX",demo.intToRoman(9));
        assertEquals("LVIII",demo.intToRoman(58));
        assertEquals("MCMXCIV",demo.intToRoman(1994));
    }
}