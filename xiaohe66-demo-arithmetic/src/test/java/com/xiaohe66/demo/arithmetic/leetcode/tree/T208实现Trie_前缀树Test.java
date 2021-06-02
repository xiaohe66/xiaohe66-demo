package com.xiaohe66.demo.arithmetic.leetcode.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T208实现Trie_前缀树Test {

    T208实现Trie_前缀树.Impl demo = new T208实现Trie_前缀树.Impl();

    @Test
    public void test1() {

        assertFalse(demo.search("a"));
        assertFalse(demo.startsWith("a"));

        demo.insert("a");
        demo.insert("ab");
        demo.insert("aa");
        demo.insert("axyz");
        demo.insert("abxyz");
        demo.insert("ab");
        demo.insert("bb");
        demo.insert("bxyz");

        assertFalse(demo.search("x"));

        assertTrue(demo.search("axyz"));
        assertTrue(demo.search("bxyz"));
        assertTrue(demo.search("bb"));


        assertFalse(demo.startsWith("l"));
        assertFalse(demo.startsWith("lm"));
        assertFalse(demo.startsWith("abcx"));
        assertFalse(demo.startsWith("axyzb"));

        assertTrue(demo.startsWith("a"));
        assertTrue(demo.startsWith("a"));
        assertTrue(demo.startsWith("ab"));
        assertTrue(demo.startsWith("aa"));
        assertTrue(demo.startsWith("ax"));
        assertTrue(demo.startsWith("axy"));
        assertTrue(demo.startsWith("axyz"));
        assertTrue(demo.startsWith("b"));
        assertTrue(demo.startsWith("bb"));
        assertTrue(demo.startsWith("bxyz"));


    }
}