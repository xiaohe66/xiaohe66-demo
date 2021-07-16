package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * @author xiaohe
 * @time 2021.07.16 13:51
 * @see T34在排序数组中查找元素的第一个和最后一个位置
 */
public class 剑指Offer53在排序数组中查找数字 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41 MB, 在所有 Java 提交中击败了94.52%的用户
     */
    public int search(int[] nums, int target) {

        if (nums.length > 0) {

            int left = help(nums, 0, target - 1);

            if (nums[left] == target) {
                /*
                right 可能的指向：
                1. 指向最后一个相同元素（相同元素在最后一位）
                2. 指向最后一个相同元素的下一个（相同元素不在最后一位）
                 */
                int right = help(nums, left, target);

                if (nums[right] > target) {
                    return right - left;

                } else {
                    return right - left + 1;
                }
            }
        }

        return 0;
    }

    public int help(int[] nums, int left, int target) {

        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (target >= nums[mid]) {

                // [mid+1,right]
                left = mid + 1;

            } else {

                // [left, mid]
                right = mid;

            }
        }

        return left;
    }

}
