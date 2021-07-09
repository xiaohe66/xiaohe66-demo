package com.xiaohe66.demo.arithmetic.leetcode.other;

/**
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * <p>
 * 示例 1：
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：[3,2]
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 通过次数43,164提交次数78,691
 *
 * @author xiaohe
 * @time 2021.07.09 09:55
 */
public class 面试题17_10主要元素 {


    /**
     * 投票算法
     * 思路来自官方题解，代码自己手写
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：44.2 MB, 在所有 Java 提交中击败了28.34%的用户
     */
    public int majorityElement(int[] nums) {

        int maybe = 0;
        int count = 0;

        for (int num : nums) {

            if (maybe == num) {
                count++;

            } else if (count == 0) {
                maybe = num;
                count = 1;

            } else {
                count--;
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == maybe) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return maybe;
        }


        return -1;
    }

}
