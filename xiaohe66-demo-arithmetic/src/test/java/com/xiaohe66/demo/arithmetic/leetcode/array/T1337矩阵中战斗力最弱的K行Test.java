package com.xiaohe66.demo.arithmetic.leetcode.array;

import com.xiaohe66.demo.arithmetic.leetcode.LeetCodeUtils;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class T1337矩阵中战斗力最弱的K行Test {

    private T1337矩阵中战斗力最弱的K行 demo = new T1337矩阵中战斗力最弱的K行();

    @Test
    public void test1() {


        assertArrayEquals(new int[]{2, 0, 3, 1}, demo.kWeakestRows(LeetCodeUtils.stringToArr2(
                "[[1,1,1,0,0,0,0],[1,1,1,1,1,1,0],[0,0,0,0,0,0,0],[1,1,1,0,0,0,0],[1,1,1,1,1,1,1]]"), 4));

        assertArrayEquals(new int[]{1}, demo.kWeakestRows(LeetCodeUtils.stringToArr2("[[1,1],[1,0]]"), 1));
        assertArrayEquals(new int[]{0}, demo.kWeakestRows(LeetCodeUtils.stringToArr2("[[1,0],[1,0]]"), 1));
        assertArrayEquals(new int[]{0, 1}, demo.kWeakestRows(LeetCodeUtils.stringToArr2("[[1,0],[1,0]]"), 2));
        assertArrayEquals(new int[]{0, 1}, demo.kWeakestRows(LeetCodeUtils.stringToArr2("[[0,0],[1,1]]"), 2));
        assertArrayEquals(new int[]{1, 0}, demo.kWeakestRows(LeetCodeUtils.stringToArr2("[[1,1],[0,0]]"), 2));

        assertArrayEquals(new int[]{2, 0, 3}, demo.kWeakestRows(LeetCodeUtils.stringToArr2("[[1,1,0,0,0]," +
                "[1,1,1,1,0]," +
                "[1,0,0,0,0]," +
                "[1,1,0,0,0]," +
                "[1,1,1,1,1]]"), 3));

        assertArrayEquals(new int[]{0, 2}, demo.kWeakestRows(LeetCodeUtils.stringToArr2("[[1,0,0,0]," +
                "[1,1,1,1]," +
                "[1,0,0,0]," +
                "[1,0,0,0]]"), 2));

    }

}