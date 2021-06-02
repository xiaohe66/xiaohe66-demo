package com.xiaohe66.demo.arithmetic.my;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class BinaryInsertTest {

    BinaryInsert demo = new BinaryInsert();

    //@Test
    public void test1() {
        test1(new int[]{31, 197, 38, 156, 161, 147, 68, 157, 119, 192});
        test1(new int[]{6, 3, 7, 4});
    }

    @Test
    public void test2() {

        Random random = new Random();

        BinaryInsert binaryInsert = new BinaryInsert();

        int n = 100;

        for (int i = 0; i < n; i++) {

            int bit = random.nextInt(100);

            int[] arr1 = new int[bit];
            int[] arr2 = new int[bit];

            for (int j = 0; j < bit; j++) {
                int num = random.nextInt(bit * 2);

                arr1[j] = num;
                binaryInsert.add(arr2, num, 0, j);
            }

            Arrays.sort(arr1);
            assertArrayEquals(arr1,arr2);
        }
    }


    public void test1(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            demo.add(arr, arr[i], 0, i);
        }

        System.out.println(Arrays.toString(arr));
    }
}