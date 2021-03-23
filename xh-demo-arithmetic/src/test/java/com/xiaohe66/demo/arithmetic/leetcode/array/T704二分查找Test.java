package com.xiaohe66.demo.arithmetic.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class T704二分查找Test {


    T704二分查找 demo = new T704二分查找();

    @Test
    public void test1() {

        test(-1,new int[]{},1);
        test(-1,new int[]{2},1);

        test(0,new int[]{1},1);
        test(0,new int[]{1,2},1);
        test(1,new int[]{1,2},2);

        test(1,new int[]{1,2,3},2);

        test(2,new int[]{1,2,3},3);

        test(1,new int[]{1,2,3,4},2);

        test(3,new int[]{1,2,3,4},4);
    }

    private void test(int correct,int[] arr, int target){

        assertEquals(correct,demo.search1(arr,target));
        assertEquals(correct,demo.search2(arr,target));
    }
}