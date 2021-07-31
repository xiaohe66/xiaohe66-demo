package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author xiaohe
 * @time 2021.07.31 18:15
 */
public class T987二叉树的垂序遍历 {

    /**
     * 执行用时：5 ms在所有 Java 提交中击败了25.81%的用户
     * 内存消耗：38.7 MB在所有 Java 提交中击败了24.04%的用户
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

        help(map, root, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();

        for (Map.Entry<Integer, Map<Integer,List<Integer>>> colEntry : map.entrySet()) {

            Map<Integer,List<Integer>> rowMap = colEntry.getValue();

            List<Integer> ansItem = new ArrayList<>();

            for (Map.Entry<Integer, List<Integer>> entry : rowMap.entrySet()) {
                entry.getValue().sort(null);
                ansItem.addAll(entry.getValue());
            }
            ans.add(ansItem);
        }

        return ans;
    }

    private void help(Map<Integer, Map<Integer, List<Integer>>> colMap, TreeNode node, int col, int row) {

        if (node == null) {
            return;
        }
        Map<Integer, List<Integer>> rowMap = colMap.computeIfAbsent(col, k -> new TreeMap<>());
        List<Integer> list = rowMap.computeIfAbsent(row, k -> new ArrayList<>());

        list.add(node.val);

        help(colMap, node.left, col - 1, row + 1);
        help(colMap, node.right, col + 1, row + 1);
    }
}
