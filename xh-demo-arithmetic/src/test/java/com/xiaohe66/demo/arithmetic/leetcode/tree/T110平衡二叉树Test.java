package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.对称二叉树;
import org.junit.Test;

import static org.junit.Assert.*;

public class T110平衡二叉树Test {

    T110平衡二叉树 demo = new T110平衡二叉树();

    @Test
    public void testIsSymmetric() {

        T110平衡二叉树.TreeNode node = new T110平衡二叉树.TreeNode();

        assertTrue(demo.isBalanced(node));
        node.left = createNode();
        assertTrue(demo.isBalanced(node));

        node.left.left = createNode();
        assertFalse(demo.isBalanced(node));

        node.right = createNode();
        assertTrue(demo.isBalanced(node));

        node.left.left.left = createNode();
        assertFalse(demo.isBalanced(node));

        node.left.left.right = createNode();
        assertFalse(demo.isBalanced(node));

        node.left.right = createNode();
        assertFalse(demo.isBalanced(node));

        node.right.right = createNode();
        assertTrue(demo.isBalanced(node));

        node.right.right.right = createNode();
        assertFalse(demo.isBalanced(node));

        node.right.left = createNode();
        assertTrue(demo.isBalanced(node));

    }

    private T110平衡二叉树.TreeNode createNode(){
        return new T110平衡二叉树.TreeNode();
    }
}