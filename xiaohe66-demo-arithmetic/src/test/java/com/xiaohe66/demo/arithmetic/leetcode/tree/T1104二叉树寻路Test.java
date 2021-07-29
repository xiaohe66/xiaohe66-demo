package com.xiaohe66.demo.arithmetic.leetcode.tree;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class T1104二叉树寻路Test {

    private T1104二叉树寻路 demo = new T1104二叉树寻路();

    @Test
    public void test1() {

        assertEquals(Arrays.asList(1), demo.pathInZigZagTree(1));
        assertEquals(Arrays.asList(1, 3, 4, 15, 17, 60, 70, 243, 281, 973, 1124, 3894, 4499, 15576, 17999, 62304, 71999, 249217, 287996, 996870), demo.pathInZigZagTree(996870));
        assertEquals(Arrays.asList(1, 3, 4, 14, 19, 57, 76, 230, 307, 920, 1230, 3683, 4921, 14732, 19687), demo.pathInZigZagTree(19687));

        assertEquals(Arrays.asList(1, 3, 4, 14), demo.pathInZigZagTree(14));
        assertEquals(Arrays.asList(1, 2, 6, 10, 26), demo.pathInZigZagTree(26));

    }

}