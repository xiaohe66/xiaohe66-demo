package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * <p>
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * <p>
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *  
 * <p>
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 *
 * <p>
 * 通过次数103,836提交次数185,513
 *
 * @author xiaohe
 * @time 2021.03.23 14:47
 */
public class T704二分查找 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了44.84%的用户
     */
    public int search2(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left + 1) / 2;

            if (nums[mid] > target) {

                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (nums[left] == target) {
            return left;
        }


        return -1;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了73.23%的用户
     */
    public int search1(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;

            } else if (nums[mid] > target) {
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

}
