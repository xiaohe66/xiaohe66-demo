package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * <p>
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 * <p>
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *  
 * <p>
 * 提示：
 * 树中节点数目在范围 [2, 100] 内
 * 0 <= Node.val <= 105
 *
 * <p>
 * 通过次数32,431提交次数56,660
 *
 * @author xiaohe
 * @time 2021.04.13 09:44
 */
public class T783二叉搜索树节点最小距离 {

    int res;
    int pre;


    /**
     * 看了官方题解才完成该题。
     *
     * <p>
     * 对于二叉搜索树，使用中序遍历即可取得一个有序序列。
     * 只要在每一个节点与它的上一个节点进行比较，即可得出差值的最小值。
     *
     * <p>
     * 个人总结：
     * 最初错误理解题意，导致解答错误。正确理解题意后，虽然有想到使用中序遍历得到一个有序序列，但是未想到用一个成员变量记录上一步的值。
     * 很多算法，虽然知道其原理和特点。但是在真正编码代码的时候，无法快速应用，有很多细节需要处理，如边界问题等等。
     * 因此，未来还需要加深各种算法的理解和练习。
     *
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了83.24%的用户
     */
    public int minDiffInBST(TreeNode root) {
        res = Integer.MAX_VALUE;
        pre = -1;
        find(root);

        return res;
    }

    public void find(TreeNode node) {

        if (node == null) {
            return;
        }

        find(node.left);

        if (pre != -1) {
            int m = node.val - pre;
            if (m < res) {
                res = m;
            }
        }

        pre = node.val;

        find(node.right);
    }

}
