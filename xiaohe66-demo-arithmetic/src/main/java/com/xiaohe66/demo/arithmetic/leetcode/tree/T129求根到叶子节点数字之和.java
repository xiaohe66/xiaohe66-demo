package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

/**
 * 中等
 *
 * <p>
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 * <p>
 * 示例 2:
 * 输入: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 * <p>
 * 通过次数53,918提交次数81,430
 *
 * @author xiaohe
 * @time 2020.10.29 11:12
 */
public class T129求根到叶子节点数字之和 {


    public int sumNumbers(TreeNode root) {

        if(root == null){
            return 0;
        }

        return sumNumbers(root, 0);
    }


    /**
     * 自己想的
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了78.36%的用户
     */
    public int sumNumbers(TreeNode root, int sum) {

        sum = sum * 10 + root.val;

        if (root.left == null) {

            if (root.right == null) {

                return sum;

            } else {
                return sumNumbers(root.right, sum);
            }

        } else {

            if (root.right == null) {

                return sumNumbers(root.left, sum);

            } else {

                return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
            }
        }
    }


}
