package com.xiaohe66.demo.arithmetic.leetcode.str;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T28实现strStrTest {

    T28实现strStr demo = new T28实现strStr();

    @Test
    public void test1() {

        assertEquals(-1, demo.strStr("ba", "abb"));
        assertEquals(0, demo.strStr("abb", "abb"));
        assertEquals(-1, demo.strStr("abb", "aaa"));
        assertEquals(-1, demo.strStr("aa", "aaa"));
        assertEquals(-1, demo.strStr("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "b"));
        assertEquals(2, demo.strStr("hello", "ll"));
        assertEquals(-1, demo.strStr("aaaaa", "bba"));
        assertEquals(0, demo.strStr("", ""));

    }
}