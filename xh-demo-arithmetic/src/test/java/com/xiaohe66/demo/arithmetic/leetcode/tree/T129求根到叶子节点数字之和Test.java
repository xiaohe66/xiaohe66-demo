package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T129求根到叶子节点数字之和Test {

    T129求根到叶子节点数字之和 demo = new T129求根到叶子节点数字之和();

    @Test
    public void test1() {

        TreeNode root;

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertEquals(25, demo.sumNumbers(root));

        root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        assertEquals(1026, demo.sumNumbers(root));

    }

    @Test
    public void test2() {

        TreeNode root;

        root = new TreeNode(1);
        root.left = new TreeNode(0);
        assertEquals(10, demo.sumNumbers(root));

    }
}