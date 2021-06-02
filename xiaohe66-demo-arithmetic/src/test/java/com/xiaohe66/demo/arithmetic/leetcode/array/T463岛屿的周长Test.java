package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T463岛屿的周长Test {

    T463岛屿的周长 demo = new T463岛屿的周长();

    @Test
    public void test1() {

        int[][] arr;

        arr = new int[][]{
                {1}
        };
        assertEquals(4, demo.islandPerimeter(arr));

        arr = new int[][]{
                {1, 1}
        };
        assertEquals(6, demo.islandPerimeter(arr));

        arr = new int[][]{
                {1, 1, 1}
        };
        assertEquals(8, demo.islandPerimeter(arr));

        arr = new int[][]{
                {1},
                {1},
        };
        assertEquals(6, demo.islandPerimeter(arr));

        arr = new int[][]{
                {1},
                {1},
                {1},
        };
        assertEquals(8, demo.islandPerimeter(arr));


        arr = new int[][]{
                {1,1},
                {1,1},
                {1,1},
        };
        assertEquals(10, demo.islandPerimeter(arr));

        arr = new int[][]{
                {1,0},
                {0,0},
                {0,0},
        };
        assertEquals(4, demo.islandPerimeter(arr));

    }
}