package com.xiaohe66.demo.arithmetic.leetcode.str;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T647回文子串Test {

    T647回文子串 demo = new T647回文子串();

    @Test
    public void test1() {

        assertEquals(3, demo.countSubstrings("abc"));
        assertEquals(6, demo.countSubstrings("aaa"));
        assertEquals(4, demo.countSubstrings("aba"));
        assertEquals(4+1+1, demo.countSubstrings("aaba"));


    }
}