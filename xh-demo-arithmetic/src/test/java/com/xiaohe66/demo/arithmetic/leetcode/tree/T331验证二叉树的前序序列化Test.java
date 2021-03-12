package com.xiaohe66.demo.arithmetic.leetcode.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class T331验证二叉树的前序序列化Test {

    T331验证二叉树的前序序列化 demo = new T331验证二叉树的前序序列化();


    @Test
    public void test1() {

        assertTrue(demo.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        assertTrue(demo.isValidSerialization("9,#,#"));

        assertFalse(demo.isValidSerialization("1,#"));
        assertFalse(demo.isValidSerialization("9,#,#,1"));


    }
}