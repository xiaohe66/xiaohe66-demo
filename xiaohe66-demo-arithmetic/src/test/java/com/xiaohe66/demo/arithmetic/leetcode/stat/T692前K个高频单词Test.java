package com.xiaohe66.demo.arithmetic.leetcode.stat;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class T692前K个高频单词Test {


    T692前K个高频单词 demo = new T692前K个高频单词();


    @Test
    public void test1() {

        assertEquals(Arrays.asList("i", "love"), demo.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        assertEquals(Arrays.asList("the", "is", "sunny", "day"), demo.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));

    }
}