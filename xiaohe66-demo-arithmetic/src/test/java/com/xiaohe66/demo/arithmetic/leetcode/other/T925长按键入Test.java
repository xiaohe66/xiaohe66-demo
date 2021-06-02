package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import static org.junit.Assert.*;

public class T925长按键入Test {

    T925长按键入 demo = new T925长按键入();

    @Test
    public void test1() {

        assertTrue(demo.isLongPressedName("abc","aabbcc"));
        assertTrue(demo.isLongPressedName("abc","abc"));
        assertTrue(demo.isLongPressedName("abc","aabc"));
        assertTrue(demo.isLongPressedName("a","a"));
        assertTrue(demo.isLongPressedName("abbc","abbc"));
        assertTrue(demo.isLongPressedName("abbcd","abbbccd"));

        assertFalse(demo.isLongPressedName("abc","ab"));
        assertFalse(demo.isLongPressedName("abc","aaaabb"));
        assertFalse(demo.isLongPressedName("abc","abbbbbb"));
        assertFalse(demo.isLongPressedName("abcb","abbbbbbc"));
        assertFalse(demo.isLongPressedName("abb","aab"));

        assertFalse(demo.isLongPressedName("alex","alexxr"));

    }
}