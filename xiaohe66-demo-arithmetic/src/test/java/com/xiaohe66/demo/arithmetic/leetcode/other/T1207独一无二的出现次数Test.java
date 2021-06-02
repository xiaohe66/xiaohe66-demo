package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import static org.junit.Assert.*;

public class T1207独一无二的出现次数Test {

    private T1207独一无二的出现次数 demo = new T1207独一无二的出现次数();


    @Test
    public void test1() {


        assertTrue(demo.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        assertTrue(demo.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
        assertFalse(demo.uniqueOccurrences(new int[]{1,2}));

        assertTrue(demo.uniqueOccurrences(new int[0]));

    }
}