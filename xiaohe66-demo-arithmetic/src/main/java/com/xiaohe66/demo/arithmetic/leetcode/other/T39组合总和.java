package com.xiaohe66.demo.arithmetic.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * <p>
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * <p>
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 *
 * <p>
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 * <p>
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * @author xiaohe
 * @time 2020.09.09 13:47
 */
public class T39组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        Set<List<Integer>> ret = new HashSet<>();

        for (int i = candidates.length - 1; i >= 0; i--) {

            List<Integer> row = new ArrayList<>();
            find(candidates, target, i, ret, row);

        }

        return new ArrayList<>(ret);
    }

    private void find(int[] arr, int target, int end, Set<List<Integer>> ret, List<Integer> row) {

        if (target == 0) {
            ret.add(new ArrayList<>(row));
            return;
        }

        for (int i = end; i >= 0; i--) {

            int maxQty = target / arr[i];

            for (int j = 0; j < maxQty; j++) {
                row.add(arr[i]);
            }

            for (int qty = maxQty; qty >= 1; qty--) {

                int newTarget = target - arr[i] * qty;

                find(arr, newTarget, i - 1, ret, row);
                row.remove(row.size() - 1);
            }

        }
    }

}
