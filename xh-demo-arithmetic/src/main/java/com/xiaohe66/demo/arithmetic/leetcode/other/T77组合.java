package com.xiaohe66.demo.arithmetic.leetcode.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * <p>
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author xiaohe
 * @time 2020.09.08 10:08
 */
public class T77组合 {


    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> list = new ArrayList<>();

        int[] row = new int[k];

        combine(list, row, 0, 1, n - k + 1);

        return list;
    }

    /**
     * 回溯法通用模板
     *
     * @param list     结果集，用于保存最终结果
     * @param row      记录集，用于记录过程，若结果不匹配，则会产生回溯
     * @param rowIndex 当前待记录的记录集下标
     * @param start    开始节点
     * @param max      最大节点
     */
    private void combine(List<List<Integer>> list, int[] row, int rowIndex, int start, int max) {

        // 结束条件
        if (row.length == rowIndex) {

            // 保存结果
            List<Integer> rowList = new ArrayList<>(row.length);
            for (int item : row) {
                rowList.add(item);
            }
            list.add(rowList);

        } else {
            // 遍历
            for (int i = start; i <= max; i++) {

                // 记录
                row[rowIndex] = i;
                // 向下尝试
                combine(list, row, rowIndex + 1, i + 1, max + 1);

            }
        }

    }


    public List<List<Integer>> combineBak(int n, int k) {

        if (k == 1) {
            List<List<Integer>> list = new ArrayList<>(n);
            for (int i = 1; i <= n; i++) {
                list.add(Collections.singletonList(i));
            }
            return list;
        }

        List<List<Integer>> list = new ArrayList<>();

        int max = n - k + 1;
        for (int i = 1; i <= max; i++) {

            int[] row = new int[k];
            row[0] = i;
            combineBak(list, row, max + 1, k - 1, i + 1, 1);
        }

        return list;
    }

    private void combineBak(List<List<Integer>> list, int[] row, int max, int k, int start, int rowIndex) {

        for (int i = start; i <= max; i++) {
            row[rowIndex] = i;
            int nextK = k - 1;
            if (nextK <= 0) {
                List<Integer> nRow = new ArrayList<>(row.length);
                for (int j : row) {
                    nRow.add(j);
                }
                list.add(nRow);
            } else {
                combineBak(list, row, max + 1, nextK, i + 1, rowIndex + 1);
            }
        }

    }

}
