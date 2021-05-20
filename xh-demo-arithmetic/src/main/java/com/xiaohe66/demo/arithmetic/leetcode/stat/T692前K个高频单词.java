package com.xiaohe66.demo.arithmetic.leetcode.stat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * <p>
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 *
 * <p>
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 *  
 * <p>
 * 注意：
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *  
 * <p>
 * 扩展练习：
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 *
 * <p>
 * 通过次数37,594提交次数68,216
 *
 * @author xiaohe
 * @time 2021.05.20 13:46
 */
public class T692前K个高频单词 {

    /**
     * Hash表 + 优先队列：
     * 1.优先队列会自动保持有序，需要注意的是，优先队列在队头的是最大的，队尾是最小的。
     * 而该题目在使用优先队列时，需要把出现频率在k之外的排除在外，也就是把更小的排除在外。
     * 因此这里就需要把优化队列的大小定义反过来，也就是队头放最小的，而队尾放最大的。在写 Comparator 时需要注意这一点。
     * 2.当第1步倒置之后，出队的顺序是按从小到大排列的，因此最终需要把结果倒置一下。
     *
     * <p>
     * 执行用时：7 ms, 在所有 Java 提交中击败了91.95%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了87.61%的用户
     */
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {
                return e2.getKey().compareTo(e1.getKey());
            } else {
                return e1.getValue() - e2.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<String> list = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            list.add(queue.poll().getKey());
        }

        Collections.reverse(list);

        return list;
    }


    /**
     * 暴力解法：hash表统计+排序
     *
     * <p>
     * 执行用时：9 ms, 在所有 Java 提交中击败了24.99%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了48.08%的用户
     */
    public List<String> topKFrequent2(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {
                return e1.getKey().compareTo(e2.getKey());
            } else {
                return e1.getValue() > e2.getValue() ? -1 : 1;
            }
        });

        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ret.add(entryList.get(i).getKey());
        }

        return ret;
    }
}
