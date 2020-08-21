package com.xiaohe66.demo.arithmetic.leetcode.tree;


import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class T101对称二叉树Test {

    @Test
    public void testIsSymmetric() {

        TreeNode node = new TreeNode(1);

        T101对称二叉树 instance = new T101对称二叉树();

        node.left = createNode(2);
        node.right = createNode(2);

        node.left.left = createNode(3);
        node.right.right = createNode(3);
        node.left.right = createNode(4);
        node.right.left = createNode(4);

        assertTrue(instance.isSymmetric(node));

        node.right.right.right = createNode(1);

        assertFalse(instance.isSymmetric(node));

        node.left.left.left = createNode(1);

        assertTrue(instance.isSymmetric(node));


    }


    private TreeNode createNode(int val){
        return new TreeNode(val);
    }
}