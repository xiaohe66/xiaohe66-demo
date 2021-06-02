package com.xiaohe66.demo.arithmetic.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class T1269停在原地的方案数Test {

    T1269停在原地的方案数 demo = new T1269停在原地的方案数();

    @Test
    public void test1() {

        assertEquals(4,demo.numWays(3,2));
        assertEquals(2,demo.numWays(2,4));
        assertEquals(8,demo.numWays(4,2));

    }
}