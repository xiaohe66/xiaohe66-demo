package com.xiaohe66.demo.arithmetic.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class T130被围绕的区域Test {

    T130被围绕的区域 demo = new T130被围绕的区域();

    @Test
    public void test1() {
        char[][] data = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        char[][] correctData = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        test(data, correctData);
    }

    @Test
    public void test2() {
        char[][] data = new char[][]{
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        char[][] correctData = new char[][]{
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        test(data, correctData);
    }

    @Test
    public void test3() {
        char[][] data = new char[][]{
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        char[][] correctData = new char[][]{
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        test(data, correctData);
    }

    @Test
    public void test4() {
        char[][] data = new char[][]{
                {'X', 'O', 'X', 'X', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
        };
        char[][] correctData = new char[][]{
                {'X', 'O', 'X', 'X', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
        };
        test(data, correctData);
    }

    @Test
    public void test5() {
        char[][] data = new char[][]{
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}
        };
        char[][] correctData = new char[][]{
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}
        };
        test(data, correctData);
    }

    @Test
    public void test6() {
        char[][] data = new char[][]{
                {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'O'},
                {'X', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'X', 'O', 'X', 'X', 'O', 'O', 'X', 'X', 'X'},
                {'O', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O'},
                {'X', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'X', 'O'}
        };
        char[][] correctData = new char[][]{
                {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'O'},
                {'X', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'O', 'O'},
                {'X', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'X', 'O'}
        };
        test(data, correctData);
    }

    private void test(char[][] data, char[][] correctData) {
        outArr(data);
        demo.solve(data);
        outArr(data);
        for (int i = 0; i < correctData.length; i++) {
            assertArrayEquals(correctData[i], data[i]);
        }
    }

    private void outArr(char[][] data) {
        for (char[] arr : data) {

            for (char c : arr) {
                System.out.print("\t");
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }

}