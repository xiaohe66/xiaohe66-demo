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

    /**
     * 实现思路
     * <p>
     * 1.遍历距阵的四条边，当遍历到当前元素是O时，把该值设置为一个固定值（非O非X），然后进入下一步逻辑
     * 2.确定当前所在的边，如果是上，则游标向下走一步，如果是左，则向右，如果是右，则向左。
     * 3.判断这个新的点是否为O，若为O，则设置为第1步的那个固定值，并且以这个新的点为起点，游标分别行走除了当前边的方向（若当前边是上，则除了上，其它3个方向都要走一遍），以这3个新的点为参数，重复第2步，直至没有O为止
     * 4.遍历整个距阵，把那个固定值改回为O，把所有O改为X
     * 5.完毕
     *
     */
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
                if (arr[i] == 'c') {
                    arr[i] = 'O';
                } else if (arr[i] == 'O') {
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
