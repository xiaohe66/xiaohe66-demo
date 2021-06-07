package com.xiaohe66.demo.arithmetic.leetcode.str;

import org.junit.Test;

import static org.junit.Assert.*;

public class T474一和零Test {

    private T474一和零 demo = new T474一和零();

    @Test
    public void test1() {

        assertEquals(0,demo.findMaxForm(new String[]{"1"},1,0));
        assertEquals(0,demo.findMaxForm(new String[]{"0"},0,1));
        assertEquals(0,demo.findMaxForm(new String[]{"0"},0,0));

        assertEquals(1,demo.findMaxForm(new String[]{"0"},1,1));
        assertEquals(1,demo.findMaxForm(new String[]{"1"},1,1));
        assertEquals(1,demo.findMaxForm(new String[]{"10"},2,1));
        assertEquals(1,demo.findMaxForm(new String[]{"10"},1,2));
        assertEquals(1,demo.findMaxForm(new String[]{"10"},1,1));
        assertEquals(1,demo.findMaxForm(new String[]{"01"},1,1));

        assertEquals(4,demo.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3));
        assertEquals(2,demo.findMaxForm(new String[]{"10", "0", "1"},1,1));

    }
}