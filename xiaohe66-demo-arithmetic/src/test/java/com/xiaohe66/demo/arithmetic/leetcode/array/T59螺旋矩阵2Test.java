package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class T59螺旋矩阵2Test {

    T59螺旋矩阵2 demo = new T59螺旋矩阵2();

    @Test
    public void test() {

        out(demo.generateMatrix(3));
        out(demo.generateMatrix(4));
        out(demo.generateMatrix(5));


    }


    private void out(int[][] arrs){

        System.out.println("-----------------------------------");
        for (int[] arr : arrs) {

            System.out.println(Arrays.toString(arr));

        }


    }
}