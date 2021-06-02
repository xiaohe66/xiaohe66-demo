package com.xiaohe66.demo.arithmetic.leetcode.str;

import org.junit.Test;

import static org.junit.Assert.*;

public class T1400构造K个回文字符串Test {

    T1400构造K个回文字符串 demo = new T1400构造K个回文字符串();

    @Test
    public void test1() {

        assertTrue(demo.canConstruct("annabelle",2));
        assertFalse(demo.canConstruct("leetcode",3));
        assertTrue(demo.canConstruct("true",4));
        assertTrue(demo.canConstruct("yzyzyzyzyzyzyzy",2));
        assertFalse(demo.canConstruct("cr",7));
        assertTrue(demo.canConstruct("aba",2));
        assertTrue(demo.canConstruct("abaa",3));

        //
        assertFalse(demo.canConstruct("abcdefghijklmnopqrstuvwxyz",25));

    }
}