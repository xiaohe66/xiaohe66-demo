package com.xiaohe66.demo.arithmetic.leetcode.str;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class T剑指Offer38字符串的排列Test {

    private T剑指Offer38字符串的排列 demo = new T剑指Offer38字符串的排列();

    @Test
    public void test1() {

        assertTrue(test("aaa", Arrays.asList("aaa")));
        assertTrue(test("abcc", Arrays.asList("abcc", "acbc", "accb", "bacc", "bcac", "bcca", "cabc", "cacb", "cbac", "cbca", "ccab", "ccba")));
        assertTrue(test("a", Arrays.asList("a")));
        assertTrue(test("abc", Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba")));
    }

    private boolean test(String s, List<String> correct) {

        HashSet<String> correctSet = new HashSet<>(correct);
        String[] ret = demo.permutation(s);

        if (correctSet.size() != ret.length) {
            return false;
        }
        return correctSet.equals(new HashSet<>(Arrays.asList(ret)));
    }

}