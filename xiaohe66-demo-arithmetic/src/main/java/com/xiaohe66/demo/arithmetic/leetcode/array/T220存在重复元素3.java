package com.xiaohe66.demo.arithmetic.leetcode.array;

import java.util.TreeSet;

/**
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * 如果存在则返回 true，不存在返回 false。
 *
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 *
 * <p>
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 *
 * <p>
 * 示例 3：
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *
 * <p>
 * 提示：
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 *
 * <p>
 * 通过次数55,334提交次数193,699
 *
 * @author xiaohe
 * @time 2021.04.19 13:49
 */
public class T220存在重复元素3 {


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0) {
            return false;
        }

        TreeSet<Long> cache = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            // [x-t, x + t]

            cache.add((long) nums[i]);
            if (i > k) {
                cache.remove((long) nums[i - k]);
            }

        }
        return false;
    }

    /**
     * 时间复杂度 O(n * k)
     * 空间复杂度 O(1)
     * <p>
     * 提交结果：超过时间限制
     */
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {

        if (k == 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {

            int j = i + 1;
            int max = Math.min(nums.length, j + k);
            for (; j < max; j++) {

                int big;
                int small;
                if (nums[i] > nums[j]) {
                    big = nums[i];
                    small = nums[j];
                } else {
                    small = nums[i];
                    big = nums[j];
                }

                if (big > 0) {
                    /**
                     * <p>small > 0
                     *
                     *      |small - big| == big - small
                     *      big - small <= t
                     *      ==> big - t <= small
                     *
                     * <p>small < 0
                     *
                     *      small - big < 0
                     *      ==> |small - big| == -small + big == big - small
                     *
                     *     big - small > 0
                     *     ==> |big - small| == big - small
                     *
                     *     big - small <= t, small < 0，因此左边可能溢出
                     *     ==> big - t <= small
                     *
                     */
                    if (big - t <= small) {
                        return true;
                    }
                } else {
                    /**
                     *
                     * <p>
                     *  big - small > 0
                     *  ==> |big - small| == big - small
                     *
                     * <p>
                     *  big - small < 0
                     *  ==> |small - big| == -small - -big == big - small
                     *
                     *  <p>
                     *  big - small <= t, big和small都小于0，则 big - t <= small，左边可能溢出
                     *  ==> big <= t + small
                     *
                     */
                    if (big <= t + small) {
                        return true;
                    }
                }

            }

        }

        return false;
    }
}
