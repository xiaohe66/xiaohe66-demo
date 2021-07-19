package com.xiaohe66.demo.arithmetic.leetcode.best;

import org.junit.Test;

import static org.junit.Assert.*;

public class T1838最高频元素的频数Test {

    private T1838最高频元素的频数 demo = new T1838最高频元素的频数();

    @Test
    public void test1() {


        assertEquals(5,demo.maxFrequency(new int[]{1,2,3,4,5,6,7,8,9,10},10));

        assertEquals(1,demo.maxFrequency(new int[]{2},2));
        assertEquals(1,demo.maxFrequency(new int[]{1},5));

        assertEquals(3,demo.maxFrequency(new int[]{1,2,4},5));
        assertEquals(2,demo.maxFrequency(new int[]{1,4,8,13},5));
        assertEquals(1,demo.maxFrequency(new int[]{3,9,6},2));


    }

}