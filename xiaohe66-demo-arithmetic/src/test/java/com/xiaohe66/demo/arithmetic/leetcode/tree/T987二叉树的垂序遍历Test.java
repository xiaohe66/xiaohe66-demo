package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.LeetCodeUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class T987二叉树的垂序遍历Test {

    private T987二叉树的垂序遍历 demo = new T987二叉树的垂序遍历();

    @Test
    public void test1() {

        assertEquals(Arrays.asList(
                Arrays.asList(0),
                Arrays.asList(1),
                Arrays.asList(3,2,2),
                Arrays.asList(4)
                ),
                demo.verticalTraversal(LeetCodeUtils.arrayToTreeNode(new Integer[]{3,1,4,0,2,2})));

        assertEquals(Arrays.asList(
                Arrays.asList(9),
                Arrays.asList(3,15),
                Arrays.asList(20),
                Arrays.asList(7)
                ),
                demo.verticalTraversal(LeetCodeUtils.arrayToTreeNode(new Integer[]{3,9,20,null,null,15,7})));
        assertEquals(Arrays.asList(
                Arrays.asList(4),
                Arrays.asList(2),
                Arrays.asList(1, 5, 6),
                Arrays.asList(3),
                Arrays.asList(7)
                ),
                demo.verticalTraversal(LeetCodeUtils.arrayToTreeNode(new Integer[]{1, 2, 3, 4, 5,6, 7})));
        assertEquals(Arrays.asList(
                Arrays.asList(4),
                Arrays.asList(2),
                Arrays.asList(1, 5, 6),
                Arrays.asList(3),
                Arrays.asList(7)
                ),
                demo.verticalTraversal(LeetCodeUtils.arrayToTreeNode(new Integer[]{1, 2, 3, 4, 6, 5, 7})));

    }
}