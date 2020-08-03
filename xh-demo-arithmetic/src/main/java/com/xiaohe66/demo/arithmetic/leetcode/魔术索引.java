package com.xiaohe66.demo.arithmetic.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * 魔术索引。
 * <p>在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * 给定一个正序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *
 * <p>示例1:
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 *
 * <p>示例2:
 * 输入：nums = [1, 1, 1]
 * 输出：1
 *
 * <p>说明:
 * nums长度在[1, 1000000]之间
 * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
 *
 * @author xiaohe
 * @time 2020.07.31 14:31
 */
public class 魔术索引 {


    private static int impl1(int[] numbs) {

        for (int i = 0; i < numbs.length; i++) {
            if (numbs[i] == i) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 对比实现1，该算法在于跳过一些不需要判断的下标
     *
     * <p>若存在数组 [1,4,4,4,5,6,6,9]，当判断到下标1（第1个4的时候），
     * 由于数组是有序的，且需要满足 arr[i] = i，因此下标小于4的数，都不满足 arr[i] = i，因为下标小于4的数，都比4大
     * 因此，到这时，可以跳过中间数的判断，直接从下标4重新开始，这样就可以省掉很多的判断步骤
     *
     * @param numbs
     * @return
     */
    private static int impl2(int[] numbs) {
        for (int i = 0; i < numbs.length; ) {
            if (numbs[i] == i) {
                return i;
            }
            i = numbs[i] > i ? numbs[i] : i + 1;
        }
        return -1;
    }


    public static void main(String[] args) {

        int n = 10000;
        int num = (int) (n * 1.1);
        Random random = new Random();

        int[] numbs = new int[n];

        for (int i = 0; i < n; i++) {
            do{
                numbs[i] = random.nextInt(num);
            }while(numbs[i] == 0);
        }

        Arrays.sort(numbs);

        long startTime = System.currentTimeMillis();
        int ret1 = impl1(numbs);
        long endTime1 = System.currentTimeMillis();
        int ret2 = impl2(numbs);
        long endTime2 = System.currentTimeMillis();

        System.out.println(Arrays.toString(numbs));

        System.out.println(String.format("impl1 ret : %s, time : %s", ret1,endTime1 - startTime));
        System.out.println(String.format("impl1 ret : %s, time : %s", ret2,endTime2 - endTime1));


    }

}
