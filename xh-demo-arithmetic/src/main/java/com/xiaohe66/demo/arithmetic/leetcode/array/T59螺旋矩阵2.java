package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 难度：中等
 *
 * <p>
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 *
 * @author xiaohe
 * @time 2021.03.16 18:01
 */
public class T59螺旋矩阵2 {


    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.6 MB, 在所有 Java 提交中击败了45.35%的用户
     */
    public int[][] generateMatrix(int n) {
        int max = n * n;

        int[][] ret = new int[n][n];

        int i = 1;
        int x = 0;
        int y = 0;
        int offsetX = 1;
        int offsetY = 0;

        int xs = 0;
        int xm = n - 1;

        int ys = 1;
        int ym = n - 1;

        while (i <= max) {

            ret[y][x] = i++;

            if (offsetX == 0) {
                y += offsetY;

                if (y > ym) {
                    // 左转
                    offsetX = -1;
                    offsetY = 0;
                    ym--;

                    y -= 1;
                    x += offsetX;

                } else if (y < ys) {
                    offsetX = 1;
                    offsetY = 0;
                    ys++;

                    y += 1;
                    x += offsetX;

                }

            } else {
                x += offsetX;

                if (x > xm) {

                    offsetX = 0;
                    offsetY = 1;
                    xm--;

                    x -= 1;
                    y += offsetY;

                } else if (x < xs) {
                    offsetX = 0;
                    offsetY = -1;
                    xs++;

                    x += 1;
                    y += offsetY;

                }
            }

            // 更改 offsetX 和 offsetY的值；达到转向的目的
            // offsetX = 1，offsetY = 0；向右移动
            // offsetX = 0，offsetY = 1；向下移动
            // offsetX = -1，offsetY = 0；向左移动
            // offsetX = 0，offsetY = -1；向上移动
        }

        return ret;
    }

}
