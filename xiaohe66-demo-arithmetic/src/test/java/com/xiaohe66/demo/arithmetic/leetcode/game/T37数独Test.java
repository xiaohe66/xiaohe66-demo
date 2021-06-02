package com.xiaohe66.demo.arithmetic.leetcode.game;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class T37数独Test {

    T37数独 demo = new T37数独();

    char[][] board;

    public T37数独Test() {
        board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };

    }

    @Test
    public void test() {
        demo.board = board;
        out();
        demo.solveSudoku(board);
        out();
    }

    @Test
    public void testRemove() {
        out();
        testRemove(2, 0, Arrays.asList(1, 2, 4, 6, 9));
        testRemove(5, 0, Arrays.asList(1, 2, 4, 6, 8));
        testRemove(8, 6, Arrays.asList(4, 7));
        testRemove(4, 6, Arrays.asList(3, 4, 5));
    }

    private void testRemove(int x, int y, List<Integer> result) {
        demo.remove(x, y);
        assertEquals(result, demo.mark[y][x]);
    }


    private void out() {
        for (int y = 0; y < 9; y++) {
            if (y % 3 == 0) {
                System.out.println("-------------------");
            }
            for (int x = 0; x < 9; x++) {
                System.out.print(x % 3 == 0 ? "|" : " ");
                if (demo.board[y][x] == '.') {
                    System.out.print(" ");
                } else {
                    System.out.print(demo.board[y][x]);
                }
            }
            System.out.println("|");
        }
        System.out.println("-------------------");
    }
}