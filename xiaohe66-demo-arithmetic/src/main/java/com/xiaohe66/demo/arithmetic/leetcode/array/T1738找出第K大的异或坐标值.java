package com.xiaohe66.demo.arithmetic.leetcode.array;

import java.util.Arrays;

/**
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *  
 * <p>
 * 示例 1：
 * 输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 *
 * <p>
 * 示例 2：
 * 输入：matrix = [[5,2],[1,6]], k = 2
 * 输出：5
 * 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
 *
 * <p>
 * 示例 3：
 * 输入：matrix = [[5,2],[1,6]], k = 3
 * 输出：4
 * 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
 *
 * <p>
 * 示例 4：
 * 输入：matrix = [[5,2],[1,6]], k = 4
 * 输出：0
 * 解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。
 *  
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 0 <= matrix[i][j] <= 106
 * 1 <= k <= m * n
 * <p>
 * 通过次数7,658提交次数11,578
 *
 * @author xiaohe
 * @time 2021.05.19 09:56
 */
public class T1738找出第K大的异或坐标值 {

    /**
     * 执行用时：51 ms, 在所有 Java 提交中击败了98.18%的用户
     * 内存消耗：131.3 MB, 在所有 Java 提交中击败了98.18%的用户
     */
    public int kthLargestValue2(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] s = new int[m * n];
        s[0] = matrix[0][0];
        for (int j = 1; j < n; j++) {
            s[j] = s[j - 1] ^ matrix[0][j];
        }

        for (int i = 1; i < m; i++) {

            int lastI = i - 1;
            int cache = matrix[i][0];
            s[i * n] = s[lastI * n] ^ cache;

            for (int j = 1; j < n; j++) {

                cache ^= matrix[i][j];
                s[i * n + j] = s[lastI * n + j] ^ cache;
            }
        }

        // note : 使用了jdk自带的排序算法
        Arrays.sort(s);

        return s[s.length - k];
    }


    /***
     * 超出时间限制
     * 时间复杂度：O(m*n)，空间复杂度：O(m*n)
     */
    public int kthLargestValue(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] s = new int[m * n];
        s[0] = matrix[0][0];
        for (int j = 1; j < n; j++) {
            s[j] = s[j - 1] ^ matrix[0][j];
        }

        for (int i = 1; i < m; i++) {

            int lastI = i - 1;
            int cache = matrix[i][0];
            s[i * n] = s[lastI * n] ^ cache;

            for (int j = 1; j < n; j++) {

                cache ^= matrix[i][j];
                s[i * n + j] = s[lastI * n + j] ^ cache;
            }
        }

        // note : 自己写的选择排序，在数组长度很大时，效率很低。这也是导致提交时超时的原因
        int i = 0;
        for (; i < k; i++) {
            int index = i;
            for (int j = i + 1; j < s.length; j++) {
                if (s[j] > s[index]) {
                    index = j;
                }
            }
            int tmp = s[i];
            s[i] = s[index];
            s[index] = tmp;
        }

        return s[k];
    }
}
