package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 * <p>
 * 提示：
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 * <p>
 * 通过次数18,692提交次数32,618
 *
 * @author xiaohe
 * @time 2021.07.28 10:48
 */
public class T863二叉树中所有距离为K的结点 {

    Map<Integer, TreeNode> parentMap;
    List<Integer> ansList;

    /**
     * 执行用时：13 ms, 在所有 Java 提交中击败了99.66%的用户
     * 内存消耗：38.4 MB , 在所有 Java 提交中击败了70.56%的用户
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        parentMap = new HashMap<>();
        ansList = new ArrayList<>();

        findParent(root);
        findAns(target, null, k);

        return ansList;
    }

    private void findParent(TreeNode node) {

        if (node.left != null) {
            parentMap.put(node.left.val, node);
            findParent(node.left);
        }

        if (node.right != null) {
            parentMap.put(node.right.val, node);
            findParent(node.right);
        }
    }

    public void findAns(TreeNode node, TreeNode from, int sur) {
        if (node == null) {
            return;
        }
        if (sur == 0) {
            ansList.add(node.val);
            return;
        }
        if (node.left != from) {
            findAns(node.left, node, sur - 1);
        }
        if (node.right != from) {
            findAns(node.right, node, sur - 1);
        }
        if (parentMap.get(node.val) != from) {
            findAns(parentMap.get(node.val), node, sur - 1);
        }
    }


}
