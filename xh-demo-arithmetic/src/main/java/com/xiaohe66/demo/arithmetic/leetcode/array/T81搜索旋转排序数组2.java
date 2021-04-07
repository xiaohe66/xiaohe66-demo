package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 * <p>
 * 示例 1：
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 *
 * <p>
 * 示例 2：
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 *  
 * <p>
 * 提示：
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 *  
 * <p>
 * 进阶：
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 *
 * <p>
 * 通过次数68,084提交次数176,006
 *
 * @author xiaohe
 * @time 2021.04.07 10:09
 */
public class T81搜索旋转排序数组2 {


    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了88.78%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了15.62%的用户
     */
    public boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {

            if (nums[left] == target || nums[right] == target) {
                return true;
            }

            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] < nums[mid]) {
                // 左有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else if (nums[mid] < nums[right]) {
                // 右有序
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            } else {
                left++;
                right--;
            }

        }

        return false;
    }
}
