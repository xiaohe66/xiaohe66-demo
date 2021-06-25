package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T752打开转盘锁Test {

    private T752打开转盘锁 demo = new T752打开转盘锁();

    @Test
    public void test1() {

        assertEquals(6, demo.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        assertEquals(1, demo.openLock(new String[]{"8888"}, "0009"));
        assertEquals(-1, demo.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
        assertEquals(-1, demo.openLock(new String[]{"0000"}, "8888"));

    }
}