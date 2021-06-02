package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * <p>
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 * <p>
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 *  
 * <p>
 * 提示：
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 *  
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 *
 * <p>
 * 通过次数250,686提交次数609,078
 *
 * @author xiaohe
 * @time 2021.04.07 11:16
 */
public class T33搜索旋转排序数组 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了5.19%的用户
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left + 1) / 2;

            if (nums[left] < nums[mid]) {

                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;

                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;

                } else {
                    right = mid - 1;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }

        return -1;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了11.12%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了14.19%的用户
     */
    public int search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            if (nums[low] == target) {
                return low;
            }
            if (nums[high] == target) {
                return high;
            }

            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] < nums[mid]) {
                if (nums[low] < target && target < nums[mid]) {
                    high = mid - 1;

                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target < nums[high]) {
                    low = mid + 1;

                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

}
