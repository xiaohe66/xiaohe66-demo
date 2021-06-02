package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T91解码方法Test {

    T91解码方法 demo = new T91解码方法();

    @Test
    public void test1() {

        long start = System.nanoTime();
        assertEquals(1, demo.numDecodings("1"));
        assertEquals(2, demo.numDecodings("1110"));
        assertEquals(1, demo.numDecodings("110"));
        // 1,1,1,1,1,1
        // 1,1,1,1,11
        // 1,1,1,11,1
        // 1,1,11,1,1
        // 1,11,1,1,1
        // 11,1,1,1,1

        //11,11,1,1
        //11,1,11,1
        //11,1,1,11
        //1,11,11,1
        //1,11,1,11
        //1,1,11,11

        //11,11,11
        assertEquals(13, demo.numDecodings("111111"));

        assertEquals(2, demo.numDecodings("12"));
        assertEquals(3, demo.numDecodings("226"));
        assertEquals(0, demo.numDecodings("0"));
        assertEquals(0, demo.numDecodings("06"));


        System.out.println(System.nanoTime() - start);
    }
}