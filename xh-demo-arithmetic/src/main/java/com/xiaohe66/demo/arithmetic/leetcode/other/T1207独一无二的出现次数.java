package com.xiaohe66.demo.arithmetic.leetcode.other;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *  
 * <p>
 * 示例 1：
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 *
 * <p>
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：false
 *
 * <p>
 * 示例 3：
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *  
 * <p>
 * 提示：
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 * @author xiaohe
 * @time 2020.10.28 16:06
 */
public class T1207独一无二的出现次数 {


    /**
     * 未看任何资料，自已想的
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了97.81%的用户
     */
    public boolean uniqueOccurrences(int[] arr) {

        if(arr == null || arr.length == 0){
            return true;
        }

        int[] tmp = new int[arr.length];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        Arrays.sort(tmp);

        int i = 0;
        int start = 0; // 包括
        int end = 1; // 不包括
        int val = tmp[0];

        while (end < tmp.length) {

            if (tmp[end] != val) {
                tmp[i] = end - start;
                val = tmp[end];

                for (int j = 0; j < i; j++) {
                    if (tmp[j] == tmp[i]) {
                        return false;
                    }
                }
                i++;
                start = end;
            }
            end++;
        }

        tmp[i] = end - start;
        for (int j = 0; j < i; j++) {
            if (tmp[j] == tmp[i]) {
                return false;
            }
        }

        return true;
    }

}
