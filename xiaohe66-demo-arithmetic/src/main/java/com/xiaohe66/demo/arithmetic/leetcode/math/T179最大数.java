package com.xiaohe66.demo.arithmetic.leetcode.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *  
 * <p>
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 *
 * <p>
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 *
 * <p>
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 *  
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * 通过次数63,611提交次数163,931
 *
 * @author xiaohe
 * @time 2021.04.12 10:58
 */
public class T179最大数 {


    /**
     * 错了5次，哭了
     *
     * <p>
     * 执行用时：7 ms, 在所有 Java 提交中击败了45.41%的用户
     * 内存消耗：37.8 MB, 在所有 Java 提交中击败了80.44%的用户
     */
    public String largestNumber(int[] nums) {

        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }

        Map<Integer, List<List<Integer>>> numMap = new HashMap<>();
        for (int num : nums) {
            List<Integer> numArr = new ArrayList<>();
            if (num == 0) {
                numArr.add(0);
            } else {
                while (num != 0) {
                    numArr.add(num % 10);
                    num = num / 10;
                }
            }

            Collections.reverse(numArr);
            Integer firstNum = numArr.get(0);
            List<List<Integer>> numArrList = numMap.computeIfAbsent(firstNum, key -> new ArrayList<>());
            numArrList.add(numArr);
        }

        MyComparator myComparator = new MyComparator();
        StringBuilder ret = new StringBuilder();
        for (int i = 9; i >= 1; i--) {
            List<List<Integer>> numArrList = numMap.get(i);
            if (numArrList != null) {

                numArrList.sort(myComparator);

                for (List<Integer> numArr : numArrList) {
                    for (Integer num : numArr) {
                        ret.append(num);
                    }
                }
            }
        }

        if (ret.length() == 0) {
            return "0";
        }

        List<List<Integer>> zeroList = numMap.get(0);
        if (zeroList != null) {
            for (int i = 0; i < zeroList.size(); i++) {
                ret.append('0');
            }
        }

        return ret.toString();
    }

    public static class MyComparator implements Comparator<List<Integer>> {

        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {

            if (o1.size() == o2.size()) {

                for (int j = 0; j < o1.size(); j++) {
                    Integer num1 = o1.get(j);
                    Integer num2 = o2.get(j);
                    if (num1 < num2) {
                        return 1;
                    }
                    if (num1 > num2) {
                        return -1;
                    }
                }
                return 0;
            }

            List<Integer> shortList;
            List<Integer> longList;
            boolean flg;

            if (o1.size() < o2.size()) {
                shortList = o1;
                longList = o2;
                flg = false;
            } else {
                shortList = o2;
                longList = o1;
                flg = true;
            }

            // 由于 i = 1可能出现越界，因此从0开始
            int i = 0;
            int j = 0;

            while (true) {
                Integer next = longList.get(j);

                if (!next.equals(shortList.get(i))) {
                    return ((next > shortList.get(i)) ^ flg) ? 1 : -1;
                }
                i++;
                if (i == shortList.size()) {
                    i = 0;
                }
                j++;
                if (j == longList.size()) {
                    break;
                }


            }
            if (i == 0) {
                return 0;
            }

            j = 0;

            while (j < shortList.size()) {
                if (!longList.get(i).equals(shortList.get(j))) {
                    return ((longList.get(i) > shortList.get(j)) ^ flg) ? -1 : 1;
                }
                i++;
                j++;
            }
            return 0;
        }
    }

}
