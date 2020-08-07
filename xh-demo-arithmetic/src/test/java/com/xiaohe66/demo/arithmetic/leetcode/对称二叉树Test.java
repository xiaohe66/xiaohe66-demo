package com.xiaohe66.demo.arithmetic.leetcode;


import org.junit.Test;
import static org.junit.Assert.*;

public class 对称二叉树Test {

    @Test
    public void testIsSymmetric() {

        对称二叉树.Node node = new 对称二叉树.Node(1);

        对称二叉树 instance = new 对称二叉树();

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


    private 对称二叉树.Node createNode(int val){
        return new 对称二叉树.Node(val);
    }
}