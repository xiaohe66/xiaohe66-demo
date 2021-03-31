package com.xiaohe66.demo.arithmetic.leetcode.array;

import com.xiaohe66.demo.arithmetic.leetcode.LeetCodeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T90子集2Test {

    private T90子集2 demo = new T90子集2();

    @Test
    public void test1() {

        List<List<Integer>> correct = Arrays.asList(
                new ArrayList<>(0),
                Arrays.asList(1),
                Arrays.asList(1, 2),
                Arrays.asList(1, 2, 2),
                Arrays.asList(2),
                Arrays.asList(2, 2)
        );

        assertTrue(LeetCodeUtils.equalsList(correct, demo.subsetsWithDup(new int[]{1, 2, 2})));
        assertFalse(LeetCodeUtils.equalsList(correct, demo.subsetsWithDup(new int[]{1, 2, 2, 3})));

        List<List<Integer>> list = new ArrayList<>(correct);

        list.add(Arrays.asList(1, 2, 2, 3));
        list.add(Arrays.asList(2, 2, 3));
        list.add(Arrays.asList(2, 3));
        list.add(Arrays.asList(3));

        list.add(Arrays.asList(1, 3));
        list.add(Arrays.asList(1, 2, 3));

        assertTrue(LeetCodeUtils.equalsList(list, demo.subsetsWithDup(new int[]{1, 2, 2, 3})));

    }

    @Test
    public void test2() {

        List<List<Integer>> correct = new ArrayList<>();
        correct.add(new ArrayList<>(0));

        assertTrue(LeetCodeUtils.equalsList(correct, demo.subsetsWithDup(new int[]{})));

        correct.add(Arrays.asList(0));
        assertTrue(LeetCodeUtils.equalsList(correct, demo.subsetsWithDup(new int[]{0})));
    }

    @Test
    public void test3() {

        List<List<Integer>> correct = Arrays.asList(
                new ArrayList<>(0),
                Arrays.asList(1),
                Arrays.asList(1, 2),
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3),
                Arrays.asList(2),
                Arrays.asList(2, 3),
                Arrays.asList(3)
        );

        assertTrue(LeetCodeUtils.equalsList(correct, demo.subsetsWithDup(new int[]{1, 2, 3})));
    }

    @Test
    public void test4() {
        List<List<Integer>> correct = Arrays.asList(
                new ArrayList<>(0),
                Arrays.asList(2),
                Arrays.asList(2, 2),
                Arrays.asList(2, 2, 2),
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(2, 2, 2, 2, 2),
                Arrays.asList(2, 2, 2, 2, 2, 2),
                Arrays.asList(2, 2, 2, 2, 2, 2, 2)
        );


        assertTrue(LeetCodeUtils.equalsList(correct, demo.subsetsWithDup(new int[]{2, 2, 2, 2, 2, 2, 2})));
    }

    @Test
    public void test5() {

        List<List<Integer>> correct = Arrays.asList(
                new ArrayList<>(0),
                Arrays.asList(1),
                Arrays.asList(1,4),
                Arrays.asList(1,4,4),
                Arrays.asList(1,4,4,4),
                Arrays.asList(1,4,4,4,4),
                Arrays.asList(4),
                Arrays.asList(4,4),
                Arrays.asList(4,4,4),
                Arrays.asList(4,4,4,4)
        );


        assertTrue(LeetCodeUtils.equalsList(correct, demo.subsetsWithDup(new int[]{4, 4, 4, 1, 4})));


    }
}