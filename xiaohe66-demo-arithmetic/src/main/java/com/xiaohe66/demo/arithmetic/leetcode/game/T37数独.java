package com.xiaohe66.demo.arithmetic.leetcode.game;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaohe
 * @time 2020.09.15 10:12
 */
public class T37数独 {

    List<Integer>[][] mark = new List[9][9];
    char[][] board;
    int surplus = 9 * 9;
    Integer[] emptyIntArr = new Integer[0];

    public T37数独() {

    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        // 1.标记已存在的数
        List<Integer> tmp = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board[y][x] == '.') {
                    mark[y][x] = new LinkedList<>(tmp);
                } else {
                    surplus--;
                }
            }
        }

        //fill();
    }

    void fill() {
        int surplus;
        do {
            surplus = this.surplus;
            for (int i = 0; i < 10; i++) {
                for (int y = 0; y < 9; y++) {
                    for (int x = 0; x < 9; x++) {
                        remove(x, y);
                    }
                }
            }
        } while (surplus != this.surplus);

        if (this.surplus > 0) {
            // 进入假设模式
            System.out.println("进入假设");
        }
    }

    void tryFill() {

        if (surplus == 0) {
            return;
        }

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board[y][x] == '.') {

                    List<Integer> maybe = mark[y][x];
                    mark[y][x] = null;

                    for (Integer num : maybe) {

                        board[y][x] = (char) (num + '0');

                        surplus--;
                        tryFill();

                        //if (tmp == surplus) {
                            surplus++;
                            board[y][x] = '.';
                        //
                        //}
                    }
                }
            }
        }
    }

    void remove(int x1, int y1) {

        if (board[y1][x1] != '.') {
            return;
        }
        // 横向遍历
        for (int x = 0; x < x1; x++) {
            remove(x1, y1, board[y1][x]);
        }
        for (int x = x1 + 1; x < 9; x++) {
            remove(x1, y1, board[y1][x]);
        }
        // 坚向遍历
        for (int y = 0; y < y1; y++) {
            remove(x1, y1, board[y][x1]);
        }
        for (int y = y1 + 1; y < 9; y++) {
            remove(x1, y1, board[y][x1]);
        }
        // 格子遍历
        int xIndex = x1 / 3;
        int xStart = xIndex * 3;
        int xMax = xStart * 3 + 3;
        int yIndex = y1 / 3;
        int yStart = yIndex * 3;
        int yMax = yStart + 3;
        int gridIndexX = x1 % 3;
        int gridIndexY = y1 % 3;

        for (int y = yStart; y < yMax; y++) {
            if (y == gridIndexY) {
                continue;
            }
            for (int x = xStart; x < xMax; x++) {
                if (x == gridIndexX) {
                    remove(x1, y1, board[y][x]);
                }
            }
        }
    }

    void remove(int x, int y, char c) {
        if (mark[y][x] == null) {
            return;
        }

        if (c != '.') {
            Integer num = c - '0';
            if (mark[y][x].remove(num) && mark[y][x].size() == 1) {
                board[y][x] = (char) (mark[y][x].get(0) + '0');
                mark[y][x] = null;
                surplus--;
            }
        }
    }

}
