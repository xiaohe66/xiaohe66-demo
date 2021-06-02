package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * <p>
 * 示例 2：
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * <p>
 * 示例 3：
 * 输入：matrix = [[1]]
 * 输出：[[1]]
 *
 * <p>
 * 示例 4：
 * 输入：matrix = [[1,2],[3,4]]
 * 输出：[[3,1],[4,2]]
 *  
 * <p>
 * 提示：
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *
 * <p>
 * 通过次数157,834提交次数217,613
 *
 * @author xiaohe
 * @time 2021.04.01 18:05
 */
public class T48旋转图像 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了5.33%的用户
     */
    public void rotate(int[][] matrix) {

        int max = matrix.length - 1;
        int mid = max / 2;
        int tmp;

        int end;
        int i1;

        for (int tier = 0; tier <= mid; tier++) {
            end = max - tier;
            for (int i = tier; i < max - tier; i++) {
                i1 = max - i;
                tmp = matrix[tier][i];
                matrix[tier][i] = matrix[i1][tier];
                matrix[i1][tier] = matrix[end][i1];
                matrix[end][i1] = matrix[i][end];
                matrix[i][end] = tmp;
            }
        }
    }
}
