package com.xiaohe66.demo.arithmetic.leetcode.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * <p>
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * <p>
 * 示例 1：
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 *
 * <p>
 * 示例 2：
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 *
 * <p>
 * 示例 3：
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 *
 * <p>
 * 通过次数27,103提交次数66,726
 *
 * @author xiaohe
 * @time 2020.11.01 15:04
 */
public class T140单词拆分2 {

    /**
     * 看了力扣题解后，自己写的
     */
    public List<String> wordBreak(String s, List<String> wordDict) {

        Map<Integer, LinkedList<LinkedList<String>>> retMap = new HashMap<>();

        LinkedList<LinkedList<String>> ret = find(s, wordDict, 0, retMap);

        List<String> list = new ArrayList<>(ret.size());

        for (LinkedList<String> item : ret) {
            Iterator<String> iterator = item.iterator();

            if (iterator.hasNext()) {
                StringBuilder str = new StringBuilder(iterator.next());

                while (iterator.hasNext()) {
                    str.append(' ').append(iterator.next());
                }
                list.add(str.toString());
            }
        }

        return list;

    }

    private LinkedList<LinkedList<String>> find(String s, List<String> wordDict, int start, Map<Integer, LinkedList<LinkedList<String>>> retMap) {
        LinkedList<LinkedList<String>> ret = retMap.get(start);

        if (ret == null) {
            ret = new LinkedList<>();

            if (start == s.length()) {
                // todo : ???
                ret.add(new LinkedList<>());

            } else {

                for (String word : wordDict) {

                    boolean isSame = equals(s, start, word);

                    if (isSame) {

                        LinkedList<LinkedList<String>> next = find(s, wordDict, start + word.length(), retMap);

                        for (LinkedList<String> linked : next) {
                            LinkedList<String> newLinked = new LinkedList<>(linked);
                            newLinked.offerFirst(word);
                            ret.add(newLinked);
                        }

                    }
                }
            }


            retMap.put(start, ret);
        }

        return ret;
    }

    private boolean equals(String s, int start, String word) {

        if (word.length() + start > s.length()) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            char c1 = s.charAt(i + start);
            char c2 = word.charAt(i);
            if (c1 != c2) {
                // 这个关键字不合格
                return false;
            }
        }

        return true;
    }


    /**
     * 自已想的，提交后超出时间限制
     * <p>
     * 超出时间限制 test：
     * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
     * ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
     */
    public List<String> wordBreak2(String s, List<String> wordDict) {

        List<String> ret = new ArrayList<>();
        List<String> item = new ArrayList<>();

        find2(s, wordDict, 0, ret, item);
        return ret;
    }

    private void find2(String s, List<String> wordDict, int start, List<String> ret, List<String> item) {
        if (start == s.length()) {
            // 关键字合格
            if (!item.isEmpty()) {
                StringBuilder str = new StringBuilder(item.get(0));
                for (int i = 1; i < item.size(); i++) {

                    str.append(' ').append(item.get(i));
                }
                ret.add(str.toString());
            }

            return;
        }
        for (String word : wordDict) {
            for (int i = start; i <= s.length(); i++) {
                int wordIndex = i - start;
                if (wordIndex == word.length()) {
                    item.add(word);
                    find2(s, wordDict, i, ret, item);
                    item.remove(item.size() - 1);
                    break;
                }
                if (i < s.length()) {
                    char c1 = s.charAt(i);
                    char c2 = word.charAt(i - start);
                    if (c1 != c2) {
                        // 这个关键字不合格
                        break;
                    }
                }
            }
        }
    }

}
