package com.xiaohe66.demo.arithmetic.leetcode.array;

import java.util.TreeMap;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * <p>
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 *
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 *  
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * <p>
 * 通过次数63,219提交次数90,469
 *
 * @author xiaohe
 * @time 2021.04.30 09:46
 */
public class T137只出现一次的数字2 {

    /**
     * 官方题解的算法
     * 思路：对每一个二进制位上的值进行计数。由于除了答案外，其余的数都是3的倍数，因此对该计数对3取余即得到答案在该位上的值。
     *
     * <p>
     * 执行用时：2 ms, 在所有 Java 提交中击败了67.50%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了56.37%的用户
     */
    public int singleNumber(int[] nums) {

        int ans = 0;

        for (int i = 0; i < 32; i++) {

            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }

            if (total % 3 == 1) {
                ans |= (1 << i);
            }

        }

        return ans;
    }

    /**
     * 执行用时：11 ms, 在所有 Java 提交中击败了5.37%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了50.33%的用户
     */
    public int singleNumber2(int[] nums) {

        // note : 应该改为 HashMap
        TreeMap<Integer, Boolean> cache = new TreeMap<>();

        for (int num : nums) {

            Boolean value = cache.get(num);
            if (value != null) {
                if (value) {
                    cache.remove(num);
                } else {
                    cache.put(num, true);
                }
            } else {
                cache.put(num, false);
            }
        }

        return cache.firstKey();
    }

}
