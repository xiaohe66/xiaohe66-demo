package com.xiaohe66.demo.arithmetic.leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author xiaohe
 * @time 2021.08.01 21:18
 */
public class T1337矩阵中战斗力最弱的K行 {

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了39.40%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了34.33%的用户
     */
    public int[] kWeakestRows(int[][] mat, int k) {

        int[] qty = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            qty[i] = mat[i].length;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    qty[i] = j;
                    break;
                }
            }
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < qty.length; i++) {
            List<Integer> list = map.computeIfAbsent(qty[i], key -> new ArrayList<>());
            list.add(i);
        }

        int[] ans = new int[k];
        for (int i = 0; i < ans.length; ) {

            Map.Entry<Integer, List<Integer>> entry = map.pollFirstEntry();

            for (Integer integer : entry.getValue()) {

                ans[i] = integer;
                i++;
                if (i == ans.length) {

                    return ans;
                }
            }
        }

        return ans;
    }
}
