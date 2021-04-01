package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 上图是一个部分填充的有效的数独。
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * <p>
 * 示例 1:
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 *
 * <p>
 * 示例 2:
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 *
 * <p>
 * 说明:
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * <p>
 * 通过次数128,732提交次数206,927
 *
 * @author xiaohe
 * @time 2021.04.01 16:47
 */
public class T36有效的数独 {

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            int mark1 = 0;
            int mark2 = 0;
            int mark3 = 0;
            int xBefore = (i % 3) * 3;
            int yBefore = (i / 3) * 3;

            for (int j = 0; j < 9; j++) {
                int x = j % 3 + xBefore;
                int y = j / 3 + yBefore;
                if (board[y][x] != '.') {
                    int val = 1 << (board[y][x] - '1');
                    if ((val & mark3) != 0) {
                        return false;
                    } else {
                        mark3 += val;
                    }
                }
                if (board[i][j] != '.') {
                    int val = 1 << (board[i][j] - '1');
                    if ((val & mark1) != 0) {
                        return false;
                    } else {
                        mark1 += val;
                    }
                }
                if (board[j][i] != '.') {
                    int val = 1 << (board[j][i] - '1');
                    if ((val & mark2) != 0) {
                        return false;
                    } else {
                        mark2 += val;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了98.64%的用户
     */
    public boolean isValidSudoku2(char[][] board) {

        for (int y = 0; y < 9; y++) {
            int mark = 0;
            for (int x = 0; x < 9; x++) {
                if (board[y][x] != '.') {
                    int val = 1 << (board[y][x] - '1');
                    if ((val & mark) != 0) {
                        return false;
                    } else {
                        mark += val;
                    }
                }
            }
        }

        for (int x = 0; x < 9; x++) {
            int mark = 0;
            for (int y = 0; y < 9; y++) {
                if (board[y][x] != '.') {
                    int val = 1 << (board[y][x] - '1');
                    if ((val & mark) != 0) {
                        return false;
                    } else {
                        mark += val;
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            int mark = 0;
            int xBefore = (i % 3) * 3;
            int yBefore = (i / 3) * 3;
            for (int j = 0; j < 9; j++) {
                int x = j % 3 + xBefore;
                int y = j / 3 + yBefore;
                if (board[y][x] != '.') {
                    int val = 1 << (board[y][x] - '1');
                    if ((val & mark) != 0) {
                        return false;
                    } else {
                        mark += val;
                    }
                }
            }
        }

        return true;
    }
}
