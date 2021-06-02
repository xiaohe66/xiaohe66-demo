package com.xiaohe66.demo.arithmetic.leetcode.linked;

import com.xiaohe66.demo.arithmetic.leetcode.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class T92反转链表2Test {

    T92反转链表2 demo = new T92反转链表2();




    @Test
    public void test1() {

        assertEquals(new ListNode(1,3,2,4,5,6,7,8,9),demo.reverseBetween(new ListNode(1,2,3,4,5,6,7,8,9), 2, 3));
        assertEquals(new ListNode(1,5,4,3,2,6,7,8,9),demo.reverseBetween(new ListNode(1,2,3,4,5,6,7,8,9), 2, 5));
        assertEquals(new ListNode(2,1,3,4,5,6,7,8,9),demo.reverseBetween(new ListNode(1,2,3,4,5,6,7,8,9), 1, 2));

        assertEquals(new ListNode(1),demo.reverseBetween(new ListNode(1), 1, 1));

        assertEquals(new ListNode(2,1),demo.reverseBetween(new ListNode(1,2), 1, 2));
        assertEquals(new ListNode(1,2),demo.reverseBetween(new ListNode(1,2), 2, 2));

    }
}