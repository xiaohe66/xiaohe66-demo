package com.xiaohe66.demo.arithmetic.leetcode.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T232用栈实现队列Test {

    T232用栈实现队列.MyQueue queue = new T232用栈实现队列.MyQueue();

    @Test
    public void test1() {

        T232用栈实现队列.MyQueue queue = new T232用栈实现队列.MyQueue();
        queue.push(1); // queue is: [1]
        queue.push(2); // queue is: [1, 2] (leftmost is front of the queue)

        assertEquals(1, queue.peek());
        assertEquals(1, queue.pop());

        assertFalse(queue.empty());

        queue.push(3);

        assertFalse(queue.empty());

        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());

        assertTrue(queue.empty());

    }
}