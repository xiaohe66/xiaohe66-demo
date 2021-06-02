package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

/**
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * <p>
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 *
 * <p>
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *  
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 *
 * <p>
 * 通过次数58,401提交次数73,098
 *
 * @author xiaohe
 * @time 2021.04.27 10:12
 */
public class T938二叉搜索树的范围和 {

    private int ans;
    private int low;
    private int high;

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：46.6 MB, 在所有 Java 提交中击败了19.97%的用户
     */
    public int rangeSumBST(TreeNode root, int low, int high) {

        ans = 0;
        this.low = low;
        this.high = high;

        helper(root);

        return ans;
    }

    private void helper(TreeNode node) {

        if (node == null) {
            return;
        }

        if (node.val >= low && node.val <= high) {
            ans += node.val;
        }

        if (node.val > low) {
            helper(node.left);
        }

        if (node.val < high) {
            helper(node.right);
        }
    }
}
