package com.xiaohe66.demo.arithmetic.leetcode.hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class T面试题17_21直立方的水量Test {

    T面试题17_21直立方的水量 demo = new T面试题17_21直立方的水量();


    @Test
    public void test1() {
        assertEquals(new LinkedList<>(Arrays.asList(4, 10)), demo.findPeak(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1, 0, 1}));

        assertEquals(new LinkedList<>(Arrays.asList(4)), demo.findPeak(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1, 0}));

        assertEquals(new LinkedList<>(Arrays.asList(0, 2, 8, 10)), demo.findPeak(new int[]{1, 0, 5, 0, 4, 0, 3, 0, 6, 0, 5}));

        assertEquals(new LinkedList<>(Arrays.asList(0, 2, 10)), demo.findPeak(new int[]{1, 0, 5, 0, 4, 0, 3, 0, 4, 0, 5}));

        assertEquals(new LinkedList<>(Arrays.asList(0, 2, 6)), demo.findPeak(new int[]{1, 0, 2, 0, 1, 0, 2}));

        assertEquals(new LinkedList<>(Arrays.asList(0, 2, 6)), demo.findPeak(new int[]{1, 0, 1, 1, 0, 1, 2}));

        assertEquals(new LinkedList<>(Arrays.asList(1, 6)), demo.findPeak(new int[]{0, 1, 1, 1, 1, 1, 2}));

        assertEquals(new LinkedList<>(Arrays.asList(1)), demo.findPeak(new int[]{0, 1, 1, 1, 1, 1}));

        assertEquals(new LinkedList<>(Arrays.asList(0)), demo.findPeak(new int[]{1, 1, 1, 1, 1}));

        assertEquals(new LinkedList<>(Arrays.asList(1, 3, 7, 10)), demo.findPeak(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    public void test2() {

        assertEquals(24, demo.trap(new int[]{1, 0, 5, 0, 4, 0, 3, 0, 6, 0, 5}));

        assertEquals(4, demo.trap(new int[]{3,0,0,2}));

        assertEquals(2, demo.trap(new int[]{3,0,2}));

        assertEquals(1, demo.trap(new int[]{1,0,2}));

        assertEquals(1, demo.trap(new int[]{1,0,1}));

        assertEquals(6, demo.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));


    }
}