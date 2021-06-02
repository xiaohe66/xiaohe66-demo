package com.xiaohe66.demo.arithmetic.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 难度：中等
 * <p>
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * <p> 
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * <p>
 * 通过次数78,023提交次数124,962
 *
 * @author xiaohe
 * @time 2021.03.31 09:54
 */
public class T90子集2 {


    /**
     * 思路：
     * 对于数组上的每1个数字，都是选择与不选择的情况。
     * 使用回溯法，遍历所有的情况。
     *
     * <p>
     * 当上一个未选择，且上一个数字与当前数字相同时，可跳过当前子集的查询
     * 例：搜索 [3,3,2,1]的子集时，首个3不选和次个3不选的结果集是一样的。
     *
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了27.51%的用户
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();

        find(nums, false, 0, ret, tmp);

        return ret;
    }

    private void find(int[] nums, boolean isChoose, int cur, List<List<Integer>> ret, List<Integer> item) {

        if (cur == nums.length) {
            ret.add(new ArrayList<>(item));
            return;
        }

        find(nums, false, cur + 1, ret, item);

        if (!isChoose && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }

        item.add(nums[cur]);

        find(nums, true, cur + 1, ret, item);
        item.remove(item.size() - 1);
    }


    /**
     * 思路：回溯法
     *
     * <p>
     * 执行用时：15 ms, 在所有 Java 提交中击败了5.51%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了79.09%的用户
     */
    public List<List<Integer>> subsetsWithDup3(int[] nums) {

        Arrays.sort(nums);

        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();

        find3(nums, 0, ret, tmp);

        return ret;
    }

    private void find3(int[] nums, int start, List<List<Integer>> ret, List<Integer> item) {

        if (!ret.contains(item)) {
            ret.add(new ArrayList<>(item));
        }

        for (int i = start; i < nums.length; i++) {

            item.add(nums[i]);
            find3(nums, i + 1, ret, item);

            item.remove(item.size() - 1);
        }
    }

    /**
     * 思路：使用  {@link T90子集#subsets(int[])} 的二进制标记思路。但在加入结果集前，做去重判断
     *
     * <p>
     * 执行用时：16 ms, 在所有 Java 提交中击败了5.51%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了64.62%的用户
     */
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();

        int max = 1 << nums.length;

        for (int mark = 1; mark < max; mark++) {

            for (int i = 0; i < nums.length; i++) {
                if ((mark & (1 << i)) != 0) {
                    tmp.add(nums[i]);
                }
            }
            Collections.sort(tmp);
            if (!ret.contains(tmp)) {
                ret.add(new ArrayList<>(tmp));
            }
            tmp.clear();
        }
        ret.add(tmp);

        return ret;
    }

}
