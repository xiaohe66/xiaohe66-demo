package com.xiaohe66.demo.arithmetic.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class T20有效的括号Test {

    T20有效的括号 demo = new T20有效的括号();

    @Test
    public void test1() {

        assertTrue(demo.isValid(""));
        assertTrue(demo.isValid("()(){}[]"));
        assertTrue(demo.isValid("(()()[{}])"));
        assertTrue(demo.isValid("(()()){}"));
        assertTrue(demo.isValid("(())(){}"));
        assertTrue(demo.isValid("{()()}{}"));
        assertTrue(demo.isValid("(){(){}}"));
        assertTrue(demo.isValid("()(){}[({})]"));
        assertTrue(demo.isValid("(({[()]}()))"));

    }

    @Test
    public void test2() {

        assertFalse(demo.isValid("()()}"));
        assertFalse(demo.isValid("(()){})"));
        assertFalse(demo.isValid("(()(){}"));
        assertFalse(demo.isValid("((())(){}"));
        assertFalse(demo.isValid("()()}{}"));
        assertFalse(demo.isValid("(){(){}}}"));
        assertFalse(demo.isValid("()(){}({}))"));

        assertFalse(demo.isValid("()(){}({}))[]["));
        assertFalse(demo.isValid("([)](){}({}))"));
        assertFalse(demo.isValid("()[]()]{}({}))"));
        assertFalse(demo.isValid("()()[{}({}))"));

        assertFalse(demo.isValid("(("));

    }
}