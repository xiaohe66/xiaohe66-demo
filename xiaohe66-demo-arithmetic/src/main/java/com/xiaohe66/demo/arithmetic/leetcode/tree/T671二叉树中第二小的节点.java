package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * <p>
 * 示例 1：
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 *
 * <p>
 * 示例 2：
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 *
 * <p>
 * 通过次数32,280提交次数68,896
 *
 * @author xiaohe
 * @time 2021.07.27 10:22
 */
public class T671二叉树中第二小的节点 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.8 MB, 在所有 Java 提交中击败了26.06%的用户
     */
    public int findSecondMinimumValue(TreeNode root) {

        int ans = Integer.MIN_VALUE;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);

        do {
            TreeNode node = stack.pop();

            while (node.left != null) {

                if (node.left.val == node.right.val) {
                    stack.push(node.right);
                    node = node.left;
                    continue;
                }

                if (node.left.val == node.val) {

                    ans = Math.max(-node.right.val, ans);
                    node = node.left;
                } else {
                    ans = Math.max(-node.left.val, ans);
                    node = node.right;
                }
            }

        } while (!stack.isEmpty());

        return ans == Integer.MIN_VALUE ? -1 : -ans;
    }

}
