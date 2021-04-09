package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 难度：困难
 *
 * <p>
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * <p>
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,5]
 * 输出：1
 *
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 *
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 * <p>
 * 进阶：
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 *
 * <p>
 * 通过次数66,870提交次数128,951
 *
 * @author xiaohe
 * @time 2021.04.09 10:11
 */
public class T154寻找旋转排序数组中的最小值2 {

    /**
     * 官方题解，自编写
     */
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right) {

            mid = left + (right - left - 1) / 2;

            if (nums[mid] < nums[right]) {
                // 最小值的下标 <= mid
                right = mid;

            } else if (nums[mid] > nums[right]) {
                // 最小值的下标 > mid
                left = mid + 1;

            } else {
                // nums[mid] == nums[right]，不管nums[right]是不是最小值，
                // 删除该元素后，都会留下 nums[mid]，最此不会路过正确值
                right--;

            }
        }

        return nums[left];
    }

    /**
     * 思路：
     * 把数组分为2部分时，必然存在一边有序，一边无序。而最小值，必然在无序的那一边。由此可排除一半选项。
     *
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了86.55%的用户
     */
    public int findMin2(int[] nums) {

        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right) {

            mid = left + (right - left + 1) / 2;

            if (nums[left] < nums[mid]) {
                left = mid;

            } else if (nums[mid] < nums[right]) {
                right = mid;

            } else if (nums[mid] == nums[right]) {
                right--;

            } else {
                left++;
                /**
                 * 剩下的只有 nums[left] == nums[mid]的情况
                 * 但不可能存在 left == mid 的情况 ：
                 * left < right的最终情况为 right = left + 1,此时 mid :
                 * mid = left + (right - left + 1) / 2
                 * mid = left + (left + 1 - left + 1) / 2
                 * mid = left + (left - left + 1  + 1) / 2
                 * mid = left + (2) / 2
                 * mid = left + 1
                 */
            }

        }


        return nums[left + 1];
    }

}
