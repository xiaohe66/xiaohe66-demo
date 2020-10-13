package com.xiaohe66.demo.arithmetic.leetcode.linked;

import com.xiaohe66.demo.arithmetic.leetcode.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T24两两交换链表中的节点Test {


    T24两两交换链表中的节点 demo = new T24两两交换链表中的节点();

    @Test
    public void test1() {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode correct = new ListNode(2);
        correct.next = new ListNode(1);
        correct.next.next = new ListNode(4);
        correct.next.next.next = new ListNode(3);

        ListNode listNode = demo.swapPairs(head);

        assertEquals(correct, listNode);

    }

    @Test
    public void test2() {


        assertEquals(null, demo.swapPairs(null));

        ListNode listNode = new ListNode(1);
        ListNode correct = new ListNode(1);
        assertEquals(correct, demo.swapPairs(listNode));

    }
}