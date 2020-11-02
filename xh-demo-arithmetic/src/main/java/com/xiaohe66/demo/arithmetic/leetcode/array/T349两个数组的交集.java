package com.xiaohe66.demo.arithmetic.leetcode.array;

/**
 * @author xiaohe
 * @time 2020.11.02 09:50
 */
public class T349两个数组的交集 {


    public int[] intersection(int[] nums1, int[] nums2) {
        // todo : 待实现更优算法
        return null;
    }

    /**
     * 自己写的，第1次实现
     * <p>
     * 执行用时：10 ms, 在所有 Java 提交中击败了9.09%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了94.82%的用户
     */
    public int[] intersection2(int[] nums1, int[] nums2) {

        int[] arr1;
        int[] arr2;

        if (nums1.length < nums2.length) {
            arr1 = nums1;
            arr2 = nums2;
        } else {
            arr1 = nums2;
            arr2 = nums1;
        }

        int max = 0;
        a:
        for (int i = 0; i < arr1.length; i++) {

            for (int j = 0; j < max; j++) {
                if (arr1[i] == arr1[j]) {
                    continue a;
                }
            }

            for (int j = 0; j < arr2.length; j++) {

                if (arr1[i] == arr2[j]) {

                    int tmp = arr1[max];
                    arr1[max] = arr1[i];
                    arr1[i] = tmp;

                    max++;
                    break;
                }

            }
        }

        int[] arr = new int[max];

        System.arraycopy(arr1, 0, arr, 0, max);

        return arr;
    }

}
