package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import static org.junit.Assert.*;

public class T零钱兑换2Test {


    private T零钱兑换2 demo = new T零钱兑换2();

    @Test
    public void test1() {

        assertEquals(4, demo.change(5,new int[]{1,2,5}));
        assertEquals(0, demo.change(3,new int[]{2}));
        assertEquals(1, demo.change(10,new int[]{10}));
    }

    @Test
    public void test2() {

        assertEquals(131236043, demo.change(200,new int[]{1,2,5,6,89,8,3,90,48,91,26,28,12,34,68,18,39,56,35}));
        assertEquals(1, demo.change(2,new int[]{1}));
    }
}