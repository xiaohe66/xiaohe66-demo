package com.xiaohe66.demo.arithmetic.leetcode.linked.T234;

import com.xiaohe66.demo.arithmetic.leetcode.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T234回文链表Test {


    T234回文链表 demo = new T234回文链表();


    @Test
    public void test1() {

        assertFalse(demo.isPalindrome(new ListNode(1, 2)));

        assertTrue(demo.isPalindrome(new ListNode(1, 2, 2, 1)));

    }
}