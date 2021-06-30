package com.xiaohe66.demo.arithmetic.leetcode.hard;

import com.xiaohe66.demo.arithmetic.leetcode.LeetCodeUtils;
import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class T297二叉树的序列化与反序列化Test {

    private T297二叉树的序列化与反序列化 demo = new T297二叉树的序列化与反序列化();

    @Test
    public void test1() {

        String str = "[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]";
        Integer[] arr = {4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2};

        assertTrue(test(str, arr));

        assertTrue(test("[1,2,3,null,null,null,4]", new Integer[]{1, 2, 3, null, null, null, 4, null, null}));

        assertTrue(test("[1,2,null,3,null,4,null,5]", new Integer[]{1, 2, null, 3, null, 4, null, 5}));

        assertTrue(test("[1]", new Integer[]{1}));

        assertTrue(test("[1,2]", new Integer[]{1, 2}));

        assertTrue(test("[1]", new Integer[]{1}));

        assertTrue(test("[]", new Integer[]{}));

        assertTrue(test("[1,2,3,null,null,4,5]", new Integer[]{1, 2, 3, null, null, 4, 5}));

        assertTrue(test("[1,2,3,4,5]", new Integer[]{1, 2, 3, 4, 5}));
    }


    private boolean test(String correctSerialize, Integer[] arr) {

        TreeNode correct = LeetCodeUtils.arrayToTreeNode(arr);

        TreeNode ret = demo.deserialize(correctSerialize);

        if (!Objects.equals(correct, ret)) {

            System.err.println("deserialize correct : " + correct);
            System.err.println("deserialize but : " + ret);
            return false;
        }

        String serialize = demo.serialize(correct);

        if (!correctSerialize.equals(serialize)) {

            System.err.println("serialize correct : " + correctSerialize);
            System.err.println("serialize but : " + serialize);
            return false;
        }

        return true;
    }
}