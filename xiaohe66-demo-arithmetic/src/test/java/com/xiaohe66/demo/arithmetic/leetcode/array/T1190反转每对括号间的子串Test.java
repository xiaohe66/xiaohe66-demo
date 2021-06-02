package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T1190反转每对括号间的子串Test {

    T1190反转每对括号间的子串 demo = new T1190反转每对括号间的子串();

    @Test
    public void test1() {

        assertEquals("dcba", demo.reverseParentheses("(abcd)"));
        assertEquals("iloveu", demo.reverseParentheses("(u(love)i)"));
        assertEquals("leetcode", demo.reverseParentheses("(ed(et(oc))el)"));
        assertEquals("apmnolkjihgfedcbq", demo.reverseParentheses("a(bcdefghijkl(mno)p)q"));


    }
}