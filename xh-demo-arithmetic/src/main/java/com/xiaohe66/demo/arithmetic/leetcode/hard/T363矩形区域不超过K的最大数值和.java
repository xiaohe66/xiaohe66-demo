package com.xiaohe66.demo.arithmetic.leetcode.hard;

import java.util.Arrays;

/**
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 *
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 *
 * <p>
 * 示例 2：
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 *
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 *
 * <p>
 * 进阶：如果行数远大于列数，该如何设计解决方案？
 *
 * <p>
 * 通过次数10,885提交次数25,414
 *
 * @author xiaohe
 * @time 2021.04.22 10:08
 */
public class T363矩形区域不超过K的最大数值和 {


    public int maxSumSubmatrix(int[][] matrix, int k) {



        return -1;
    }

    /**
     * 执行用时：116 ms, 在所有 Java 提交中击败了60.10%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了67.95%的用户
     */
    public int maxSumSubmatrix3(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] sum = new int[n];
        int ret = Integer.MIN_VALUE;

        for (int y1 = 0; y1 < m; y1++) {
            Arrays.fill(sum, 0);
            for (int y2 = y1; y2 < m; y2++) {
                for (int x = 0; x < n; x++) {
                    sum[x] += matrix[y2][x];
                }
                for (int x1 = 0; x1 < n; x1++) {
                    int s = 0;
                    for (int x2 = x1; x2 < n; x2++) {
                        s += sum[x2];
                        if (s == k) {
                            return k;
                        }
                        if (s < k && s > ret) {
                            ret = s;
                        }
                    }
                }
            }
        }

        return ret;
    }

    /**
     * 时间复杂度 O(m^2 * n^2)
     * 空间复杂度 O(m * n^2)
     *
     * <p>
     * 执行用时：169 ms, 在所有 Java 提交中击败了48.42%的用户
     * 内存消耗：46.9 MB, 在所有 Java 提交中击败了5.01%的用户
     */
    public int maxSumSubmatrix2(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][][] cache = new int[m][n][n];

        int ret = Integer.MIN_VALUE;

        for (int y = 0; y < m; y++) {
            for (int x1 = 0; x1 < n; x1++) {
                int sum = 0;
                for (int x2 = x1; x2 < n; x2++) {
                    sum += matrix[y][x2];
                    cache[y][x1][x2] = sum;
                    if (sum == k) {
                        return k;
                    }
                    if (sum < k && sum > ret) {
                        ret = sum;
                    }
                }
            }
        }

        for (int y1 = 0; y1 < m; y1++) {
            for (int y2 = y1 + 1; y2 < m; y2++) {
                for (int x1 = 0; x1 < n; x1++) {

                    for (int x2 = x1; x2 < n; x2++) {

                        // cache
                        int sum = cache[y1][x1][x2] = cache[y1][x1][x2] + cache[y2][x1][x2];

                        if (sum == k) {
                            return k;
                        }
                        // 为什么超过最大值时不跳出？输入是[2,2,-1],3时，前2项的和超过了3，而加上第3项时正好符合要求。此时跳出是错误的
                        if (sum < k && sum > ret) {
                            ret = sum;
                        }
                    }
                }
            }
        }

        return ret;
    }
}
