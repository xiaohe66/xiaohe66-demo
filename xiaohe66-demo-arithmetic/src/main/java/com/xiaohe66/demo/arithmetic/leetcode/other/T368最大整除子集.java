package com.xiaohe66.demo.arithmetic.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 *
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 *
 * <p>
 * 通过次数16,385提交次数39,012
 *
 * @author xiaohe
 * @time 2021.04.23 10:31
 */
public class T368最大整除子集 {

    /**
     * 执行用时：24 ms, 在所有 Java 提交中击败了49.72%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了90.34%的用户
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 1) {
            return Collections.singletonList(nums[0]);
        }

        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxSize = 1;
        int maxIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> list = new ArrayList<>();

        int index = maxIndex;
        do {
            if (dp[index] == maxSize && nums[maxIndex] % nums[index] == 0) {
                list.add(nums[index]);

                maxIndex = index;
                maxSize--;
            }
            index--;

        } while (maxSize > 0);

        return list;
    }

}
