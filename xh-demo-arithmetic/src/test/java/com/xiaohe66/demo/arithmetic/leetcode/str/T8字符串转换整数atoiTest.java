package com.xiaohe66.demo.arithmetic.leetcode.str;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T8字符串转换整数atoiTest {

    T8字符串转换整数atoi demo = new T8字符串转换整数atoi();

    @Test
    public void test() {

        assertEquals(-2147483648, demo.myAtoi("-2147483649"));
        assertEquals(0, demo.myAtoi(" "));
        assertEquals(0, demo.myAtoi(""));

        assertEquals(42, demo.myAtoi("42"));
        assertEquals(-42, demo.myAtoi("-42"));
        assertEquals(4193, demo.myAtoi("4193 with words"));
        assertEquals(0, demo.myAtoi("words and 987"));
        assertEquals(-2147483648, demo.myAtoi("-91283472332"));


    }
}