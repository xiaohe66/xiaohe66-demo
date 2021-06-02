package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class T347前K个高频元素Test {


    T347前K个高频元素 demo = new T347前K个高频元素();

    @Test
    public void test1() {

        Set<Integer> set = toSet(1,2);
        int[] ints = demo.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        Set<Integer> ret = toSet(ints);

        assertEquals(set,ret);
    }

    @Test
    public void test2() {

        Set<Integer> set = toSet(1);
        int[] ints = demo.topKFrequent(new int[]{1}, 1);
        Set<Integer> ret = toSet(ints);

        assertEquals(set,ret);
    }

    private Set<Integer> toSet(int... arr){
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        return set;
    }
}