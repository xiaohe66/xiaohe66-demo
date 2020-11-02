package com.xiaohe66.demo.arithmetic.leetcode.str;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class T140单词拆分2Test {

    T140单词拆分2 demo = new T140单词拆分2();

    @Test
    public void test1() {


        equals(Arrays.asList("cats and dog", "cat sand dog"),
                demo.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));

        equals(Arrays.asList("pine apple pen apple", "pineapple pen apple", "pine applepen apple"),
                demo.wordBreak("pineapplepenapple", Arrays.asList("cat", "apple", "pen", "applepen", "pine", "pineapple")));

        equals(Arrays.asList(),
                demo.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));

    }

    @Test
    public void test2() {

        String a = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> word = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        List<String> strings = demo.wordBreak(a, word);
        System.out.println(strings);

    }

    private void equals(List<String> list1, List<String> list2){

        Set<String> set1 = new HashSet<>(list1);
        Set<String> set2 = new HashSet<>(list2);
        assertEquals(set1,set2);

    }
}