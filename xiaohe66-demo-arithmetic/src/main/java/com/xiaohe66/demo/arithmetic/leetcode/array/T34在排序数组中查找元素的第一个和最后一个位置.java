package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * <p>
 * 通过次数286,170提交次数672,526
 *
 * @author xiaohe
 * @time 2021.07.16 13:52
 */
public class T34在排序数组中查找元素的第一个和最后一个位置 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了16.65%的用户
     */
    public int[] searchRange(int[] nums, int target) {

        if (nums.length > 0) {

            int left = help(nums, 0, target - 1);

            if (nums[left] == target) {
                /*
                right 可能的指向：
                1. 指向最后一个相同元素（相同元素在最后一位）
                2. 指向最后一个相同元素的下一个（相同元素不在最后一位）
                 */
                int right = help(nums, left, target);

                right = nums[right] > target ? right - 1 : right;

                return new int[]{left, right};
            }

        }

        return new int[]{-1, -1};
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
