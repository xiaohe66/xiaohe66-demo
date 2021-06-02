package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T111二叉树的最小深度Test {

    T111二叉树的最小深度 demo = new T111二叉树的最小深度();

    @Test
    public void test1() {


        TreeNode root = new TreeNode();

        root.left = new TreeNode();
        assertEquals(2, demo.minDepth(root));

        root.right = new TreeNode();

        root.right.left = new TreeNode();
        root.right.right = new TreeNode();

        assertEquals(2, demo.minDepth(root));


    }
}