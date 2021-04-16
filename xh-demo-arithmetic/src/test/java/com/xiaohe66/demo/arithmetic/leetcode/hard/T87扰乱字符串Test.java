package com.xiaohe66.demo.arithmetic.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T87扰乱字符串Test {

    T87扰乱字符串.Impl demo = new T87扰乱字符串.Impl();

    @Test
    public void test1() {

        assertFalse(demo.isScramble("abcdefghijklmnopqrstuvwxyz", "zabcdefghijklmnopqrstuvwxb"));

        assertTrue(demo.isScramble("abcdefghijklmnopqrstuvwxyz", "zabcdefghijklmnopqrstuvwxy"));

        assertTrue(demo.isScramble("great", "rgeat"));
        assertFalse(demo.isScramble("abcde", "caebd"));
        assertTrue(demo.isScramble("a", "a"));

    }
}