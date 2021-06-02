package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class T368最大整除子集Test {

    T368最大整除子集 demo = new T368最大整除子集();

    @Test
    public void test1() {
        assertTrue(test(Arrays.asList(new int[]{4, 8, 240}), 4, 8, 10, 240));

        assertTrue(test(Arrays.asList(new int[]{1, 2, 4, 8}), 1, 2, 3, 4, 5, 6, 7, 8));

        assertTrue(test(Arrays.asList(new int[]{1, 2, 4, 8}), 1, 2, 4, 8));
        assertTrue(test(Arrays.asList(new int[]{1, 3}, new int[]{1, 2}), 1, 2, 3));
    }

    private boolean test(List<int[]> correctList, int... arr) {

        List<Integer> ret = demo.largestDivisibleSubset(arr);
        HashSet<Integer> retSet = new HashSet<>(ret);
        if (retSet.size() != ret.size()) {
            return false;
        }

        for (int[] correctArr : correctList) {

            List<Integer> list = new ArrayList<>(correctArr.length);
            for (int val : correctArr) {
                list.add(val);
            }

            HashSet hashSet = new HashSet<>(list);

            if (hashSet.equals(retSet)) {
                return true;
            }
        }

        return false;
    }
}