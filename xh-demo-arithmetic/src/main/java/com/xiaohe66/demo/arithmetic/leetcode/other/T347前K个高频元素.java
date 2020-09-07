package com.xiaohe66.demo.arithmetic.leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * <p>
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * @author xiaohe
 * @time 2020.09.07 11:39
 */
public class T347前K个高频元素 {

    /**
     * 力扣提交：时间上仅击败了5%的人，空间上仅击败了15%的人
     *
     * todo : 重新实现
     */
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Value> map = new HashMap<>();

        for (int num : nums) {
            Value value = map.computeIfAbsent(num, integer -> new Value());
            value.qty++;
        }

        int[] ret = new int[k];

        for (int i = 0; i < ret.length; i++) {

            Map.Entry<Integer, Value> tmp = null;
            for (Map.Entry<Integer, Value> entry : map.entrySet()) {
                if (tmp == null || entry.getValue().qty > tmp.getValue().qty) {
                    tmp = entry;
                }
            }
            ret[i] = tmp.getKey();
            tmp.getValue().qty = 0;
        }

        return ret;
    }

    private static class Value {
        int qty = 0;
    }
}
