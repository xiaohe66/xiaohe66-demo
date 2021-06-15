package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 * <p>
 * 示例 1：
 * 输入：arr = [0,1,0]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * <p>
 * 示例 5：
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 * <p>
 * 提示：
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 *  
 * 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
 * <p>
 * 通过次数59,870提交次数83,792
 *
 * @author xiaohe
 * @time 2021.06.15 13:47
 */
public class T852山脉数组的峰顶索引 {

    /**
     * 二分查找
     *
     * <p>
     * 设left = 0, right = arr.length, x为峰顶。因此x为于 [left,right)中
     * 若 arr[mid] > arr[mid - 1],那么 x in [mid,right)
     * 否则, x in [left,mid-1)
     *
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了93.53%的用户
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length;

        // 闭开区间 [0,len)
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            /*
                证明：mid - 1 >= 0
                  left + (right - left + 1)/ 2 >= 1
                = 2left + right - left + 1 >= 2
                = left + right + 1 >= 2
                = left + right >= 1
                因为 left < right,所以 left != right，且 left >= 0，所以 上式成立
             */
            if (arr[mid] > arr[mid - 1]) {
                left = mid;

            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
