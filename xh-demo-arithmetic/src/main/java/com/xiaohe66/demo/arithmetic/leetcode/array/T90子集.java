package com.xiaohe66.demo.arithmetic.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *  
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * <p>
 * 通过次数220,663提交次数277,042
 *
 * @author xiaohe
 * @time 2021.03.31 11:38
 */
public class T90子集 {

    /**
     * 思路：
     * 对于nums来说，其子集都是nums中每1个元素的选择与不选择。
     * 因此，可以使用1个整数来表示每一位是否选择（该数的2进制形式）。
     * 该数的最大值为 1 << nums.length
     *
     * <p>
     * 体会：2进制还可以这么用，妙妙妙，妙不可言。
     *
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了81.80%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了43.01%的用户
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();

        int max = 1 << nums.length;
        for (int mark = 1; mark < max; mark++) {
            for (int i = 0; i < nums.length; i++) {
                if ((mark & (1 << i)) != 0) {
                    tmp.add(nums[i]);
                }
            }
            ret.add(new ArrayList<>(tmp));
            tmp.clear();
        }
        ret.add(tmp);

        return ret;
    }


    /**
     * 思路：
     * 1.用一个集合保存结果集，初始时结果集中有1个空集
     * 2.每遍历到一个新数字时，复制当前的结果集，并在每1个集合中加入当前数字，并把复制到的结果集加入原结果集中
     * 3.重复第2步，直至遍历完整个数组
     *
     * <p>
     * 执行用时：1 ms , 在所有 Java 提交中击败了81.80%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了12.01%的用户
     */
    public List<List<Integer>> subsets4(int[] nums) {

        List<List<Integer>> tmpList = new ArrayList<>();

        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>(0));

        for (int num : nums) {

            for (List<Integer> item : ret) {

                ArrayList<Integer> newItem = new ArrayList<>(item);
                newItem.add(num);
                tmpList.add(newItem);
            }
            ret.addAll(tmpList);
            tmpList.clear();
        }

        return ret;
    }


    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了81.80%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了5.12%的用户
     */
    public List<List<Integer>> subsets3(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();
        ret.add(Collections.emptyList());

        List<List<List<Integer>>> cache = new ArrayList<>();
        cache.add(Collections.emptyList());

        for (int num : nums) {

            List<List<Integer>> curList = new ArrayList<>();

            curList.add(Collections.singletonList(num));

            for (List<List<Integer>> prevList : cache) {
                for (List<Integer> prev : prevList) {

                    List<Integer> cur = new ArrayList<>(prev.size() + 1);
                    cur.addAll(prev);
                    cur.add(num);

                    curList.add(cur);
                }
            }

            cache.add(curList);
            ret.addAll(curList);
        }

        return ret;
    }

    /**
     * 执行用时：12 ms, 在所有 Java 提交中击败了11.47%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了89.26%的用户
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(Collections.emptyList());

        List<List<List<Integer>>> cache = new ArrayList<>();
        cache.add(new ArrayList<>());

        for (int i = nums.length - 1; i >= 0; i--) {

            List<List<Integer>> curList = new ArrayList<>();

            List<Integer> item = Collections.singletonList(nums[i]);
            if (!ret.contains(item)) {
                ret.add(item);
                curList.add(item);
            }

            for (List<List<Integer>> prevList : cache) {
                for (List<Integer> prev : prevList) {
                    List<Integer> cur = new ArrayList<>(prev.size() + 1);
                    cur.add(nums[i]);
                    cur.addAll(prev);

                    if (!curList.contains(cur) && !ret.contains(cur)) {
                        curList.add(cur);
                        ret.add(cur);
                    }
                }
            }
            if (!curList.isEmpty()) {
                cache.add(curList);
            }
        }

        return ret;
    }
}
