package com.xiaohe66.demo.arithmetic.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * <p>
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 *
 * <p>
 * 示例 1：
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 *
 * <p>
 * 示例 2：
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 *
 * <p>
 * 示例 3：
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 *
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 *
 * <p>
 * 通过次数37,856提交次数157,934
 *
 * @author xiaohe
 * @time 2021.06.02 10:21
 */
public class T523连续的子数组和 {

    /**
     * 官方题解：
     * <p>
     * 执行用时：20 ms, 在所有 Java 提交中击败了54.79%的用户
     * 内存消耗：54.7 MB, 在所有 Java 提交中击败了19.06%的用户
     */
    public boolean checkSubarraySum(int[] nums, int k) {

        if (nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();

        // 前缀和出现 k 的倍数时，余数为0。因此需要提前添加一个 余数0以保证在循环中的判断成立。
        map.put(0, -1);

        int remainder = 0;

        for (int cur = 0; cur < nums.length; cur++) {

            remainder = (nums[cur] + remainder) % k;

            Integer last = map.get(remainder);
            if (last == null) {
                map.put(remainder, cur);

            } else if (cur - last >= 2) {
                return true;
            }

        }

        return false;
    }

    /**
     * 官方题解：前缀和 + Hash表
     * 对于每一个前缀和，他都有一个除以k的余数，而符合条件的子数组中，其开始下标和结束下标的前缀和的余数必然相等。
     * <p>
     * 自行写的代码：
     * 执行用时：21 ms, 在所有 Java 提交中击败了40.75%的用户
     * 内存消耗：54.4 MB, 在所有 Java 提交中击败了39.60%的用户
     */
    public boolean checkSubarraySum3(int[] nums, int k) {

        // todo : 改进点 当 nums.length < 2时，直接返回 false

        Map<Integer, Integer> map = new HashMap<>();

        // 前缀和出现 k 的倍数时，余数为0。因此需要提前添加一个 余数0以保证在循环中的判断成立。
        map.put(0, -1);

        int sum = 0;

        for (int cur = 0; cur < nums.length; cur++) {

            // todo : 改进点，sum可以去掉，直接用余数（不管sum多大，新sum的余数只和上一个余数有关）
            sum += nums[cur];

            int sur = sum % k;

            Integer last = map.get(sur);
            if (last == null) {
                map.put(sur, cur);

            } else if (cur - last > 1) {
                return true;
            }

        }

        return false;
    }

    /**
     * 提交结果：超出时间限制
     */
    public boolean checkSubarraySum2(int[] nums, int k) {

        if (nums.length < 2) {
            return false;
        }

        int[] sums = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        for (int i = 0; i < sums.length - 2; i++) {
            for (int j = i + 2; j < sums.length; j++) {

                if ((sums[j] - sums[i]) % k == 0) {
                    return true;
                }

            }
        }

        return false;
    }
}
