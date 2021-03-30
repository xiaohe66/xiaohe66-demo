package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 难度：中等
 * <p>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *  
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * <p>
 * 通过次数98,146提交次数232,097
 *
 * @author xiaohe
 * @time 2021.03.30 10:06
 */
public class T74搜索二维矩阵 {

    /**
     * 使用2分法查找，先查找 y轴，再查找 x轴
     *
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了20.56%的用户
     */
    public boolean searchMatrix2(int[][] matrix, int target) {

        int y = 0;
        int high = matrix.length - 1;
        int mid;

        while (y < high) {
            mid = y + (high - y + 1) / 2;
            if (matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                y = mid;
            }
        }

        int low = 0;
        high = matrix[y].length - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (matrix[y][mid] == target) {
                return true;

            } else if (matrix[y][mid] > target) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return false;
    }


    /**
     * 思路：把2维数组当做1维数组，使用2分法查找
     *
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.8 MB, 在所有 Java 提交中击败了80.83%的用户
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int val = matrix[mid / n][mid % n];

            if (val == target) {
                return true;

            } else if (val > target) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return false;
    }

}
