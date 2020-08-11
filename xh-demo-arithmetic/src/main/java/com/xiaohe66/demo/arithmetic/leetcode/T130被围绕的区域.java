package com.xiaohe66.demo.arithmetic.leetcode;

/**
 * <p>给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * @author xiaohe
 * @time 2020.08.11 11:08
 */
public class T130被围绕的区域 {

    void solve(char[][] board) {
        if (board.length < 2) {
            return;
        }

        char[] chars = board[0];
        if (chars.length < 2) {
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 'O') {
                chars[i] = 'c';
                v(board, i, 0, chars.length, board.length, 1);
            }
        }
        int lastIndexY = board.length - 1;
        int lastIndexX = chars.length - 1;
        for (int i = 1; i < lastIndexY; i++) {
            chars = board[i];
            char c = chars[0];
            if (c == 'O') {
                chars[0] = 'c';
                h(board, 0, i, chars.length, board.length, 1);
            }
            c = chars[lastIndexX];
            if (c == 'O') {
                chars[lastIndexX] = 'c';
                h(board, lastIndexX, i, chars.length, board.length, -1);
            }
        }
        chars = board[lastIndexY];
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 'O') {
                chars[i] = 'c';
                v(board, i, lastIndexY, chars.length, board.length, -1);
            }
        }


        for (char[] arr : board) {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == 'c'){
                    arr[i] = 'O';
                }else if(arr[i] == 'O'){
                    arr[i] = 'X';
                }
            }
        }
    }

    void h(char[][] board, int x, int y, int xMax, int yMax, int offset) {
        int newX = x + offset;
        if (newX >= xMax || newX < 0) {
            return;
        }
        char c = board[y][newX];
        if (c == 'O') {
            board[y][newX] = 'c';
            v(board, newX, y, xMax, yMax, -1);
            v(board, newX, y, xMax, yMax, 1);
            h(board, newX, y, xMax, yMax, offset);
        }
    }

    void v(char[][] board, int x, int y, int xMax, int yMax, int offset) {
        int newY = y + offset;
        if (newY >= yMax || newY < 0) {
            return;
        }
        char c = board[newY][x];
        if (c == 'O') {
            board[newY][x] = 'c';
            h(board, x, newY, xMax, yMax, -1);
            h(board, x, newY, xMax, yMax, 1);
            v(board, x, newY, xMax, yMax, offset);
        }
    }

}
