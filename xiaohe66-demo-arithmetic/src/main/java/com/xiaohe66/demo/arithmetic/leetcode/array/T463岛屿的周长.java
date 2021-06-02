package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * @author xiaohe
 * @time 2020.10.30 11:31
 */
public class T463岛屿的周长 {

    /**
     * 自己写的
     *
     * 执行用时：7 ms, 在所有 Java 提交中击败了97.52%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了23.18%的用户
     */
    public int islandPerimeter(int[][] grid) {

        int yLen = grid.length;
        if (yLen == 0) {
            return 0;
        }

        int xLen = grid[0].length;
        if (xLen == 0) {
            return 0;
        }

        int maxX = xLen - 1;
        int maxY = yLen - 1;

        int sum = 0;

        int nextY;
        int nextX;

        // 最后1行不遍历
        for (int y = 0; y < maxY; y = nextY) {

            nextY = y + 1;

            // 0 ~ n-1
            for (int x = 0; x < maxX; x = nextX) {

                nextX = x + 1;

                if (grid[y][x] == 1) {
                    sum += 4;

                    if (grid[y][nextX] == 1) {
                        sum -= 2;
                    }

                    if (grid[nextY][x] == 1) {
                        sum -= 2;
                    }
                }
            }

            // 最后1列
            if (grid[y][maxX] == 1) {

                if (grid[nextY][maxX] == 1) {
                    sum += 2;
                } else {

                    sum += 4;
                }
            }
        }

        // 遍历最后一行
        for (int x = 0; x < maxX; x = nextX) {

            nextX = x + 1;

            if (grid[maxY][x] == 1) {

                if (grid[maxY][nextX] == 1) {
                    sum += 2;
                } else {
                    sum += 4;
                }
            }
        }

        // 最后一格
        if (grid[maxY][maxX] == 1) {
            sum += 4;
        }

        return sum;
    }
}
