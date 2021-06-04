package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class T160相交链表Test {

    T160相交链表 demo = new T160相交链表();

    @Test
    public void test0() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        assertEquals(node1, demo.getIntersectionNode(node1, node1));

        assertNull(demo.getIntersectionNode(node1, node2));
    }

    @Test
    public void test1() {

        ListNode node = new ListNode(8, 4, 5);
        ListNode node1 = new ListNode(node, 4, 1);
        ListNode node2 = new ListNode(node, 5, 0, 1);

        assertEquals(node, demo.getIntersectionNode(node1, node2));
    }

    @Test
    public void test2() {

        ListNode node = new ListNode(2, 4);
        ListNode node1 = new ListNode(node, 0, 9, 1);
        ListNode node2 = new ListNode(node, 3);

        assertEquals(node, demo.getIntersectionNode(node1, node2));
    }

    @Test
    public void test3() {

        ListNode node1 = new ListNode(2, 6, 4);
        ListNode node2 = new ListNode(1, 5);

        assertNull(demo.getIntersectionNode(node1, node2));
    }


}