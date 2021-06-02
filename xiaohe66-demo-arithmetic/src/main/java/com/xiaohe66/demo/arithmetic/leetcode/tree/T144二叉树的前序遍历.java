package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 * <p>
 *  示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [1,2,3]
 *
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * <p>
 * 通过次数200,354提交次数295,208
 *
 * @author xiaohe
 * @time 2020.10.27 11:53
 */
public class T144二叉树的前序遍历 {

    /**
     * 自己想的递归算法：
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了99.81%的用户
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ret = new ArrayList<>();

        preorderTraversal(root,ret);

        return ret;
    }

    private void preorderTraversal(TreeNode root, List<Integer> ret) {
        if (root != null) {
            ret.add(root.val);
            preorderTraversal(root.left, ret);
            preorderTraversal(root.right, ret);
        }
    }

    /**
     * 自已想的迭代算法，提交结果为超过内存限制
     */
    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> ret = new ArrayList<>();

        List<TreeNode> todo = new ArrayList<>();

        while (root != null) {

            ret.add(root.val);

            if (root.left == null) {

                if (root.right == null) {
                    int i = todo.size() - 1;

                    root = i >= 0 ? todo.get(i) : null;

                } else {

                    root = root.right;
                }

            } else {

                if (root.right != null) {
                    todo.add(root.right);
                }

                root = root.left;
            }
        }

        return ret;
    }

}
