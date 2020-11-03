package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * <p>
 * 示例 1：
 * 输入：[2,1]
 * 输出：false
 *
 * <p>
 * 示例 2：
 * 输入：[3,5,5]
 * 输出：false
 *
 * <p>
 * 示例 3：
 * 输入：[0,3,2,1]
 * 输出：true
 *
 * @author xiaohe
 * @time 2020.11.03 10:45
 */
public class T941有效的山脉数组 {

    public boolean validMountainArray(int[] A) {

        if (A.length < 3) {
            return false;
        }

        int i = 0;
        int n;

        while (i < A.length - 1) {

            n = i + 1;

            if(A[i] == A[n]){
                return false;
            }

            if (A[i] > A[n]) {
                break;
            }

            i = n;
        }

        if (i == 0 || i == A.length - 1 || A[0] == A[i]) {
            return false;
        }

        while (i < A.length - 1) {

            n = i + 1;

            if (A[i] <= A[n]) {
                return false;
            }

            i = n;
        }

        return true;
    }

}
