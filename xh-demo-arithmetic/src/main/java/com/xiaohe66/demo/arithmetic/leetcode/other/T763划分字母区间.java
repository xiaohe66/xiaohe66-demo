package com.xiaohe66.demo.arithmetic.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度： 中等
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 * <p>
 * 示例 1：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 *
 * <p>
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 * <p>
 * 提示：
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 *
 * <p>
 * xiaohe 的思考：
 * 由于一个字母只能出现在一个片段中。
 * 因此当1个字母2次出现在某1片段中，那么至少可以确定该字母的首次和末次出现的位置为1个片段。
 * 基于以上原则扩展，片段中的某个字母还可能出现在片段外，因此该片段的首位和末位还必须扩展到该字母的首位和末位（取最小值和最大值）
 * 片段的长度，便是最大值和最小值差
 *
 * @author xiaohe
 * @time 2020.10.22 11:07
 */
public class T763划分字母区间 {

    /**
     * 官方题解
     */
    public List<Integer> partitionLabels_(String S) {

        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        List<Integer> partition = new ArrayList<>();

        int start = 0;
        int end = 0;

        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    /**
     * 在看了力扣题解分析后，自己写的
     * 执行用时：4 ms, 在所有 Java 提交中击败了86.91%的用户
     * 内存消耗：36.8 MB, 在所有 Java 提交中击败了97.85%的用户
     */
    public List<Integer> partitionLabels(String S) {

        if (S.length() <= 1) {
            List<Integer> ret = new ArrayList<>();
            ret.add(S.length());
            return ret;
        }

        int[] lastIndex = new int[26];

        // 确定每个字母最后出现的下标
        for (int i = 1; i < S.length(); i++) {

            int c = S.charAt(i) - 'a';

            // 点评： 这里if，每次都返回true，因此可以省略
            if (i > lastIndex[c]) {
                lastIndex[c] = i;
            }
        }

        List<Integer> ret = new ArrayList<>();


        int start = 0;

        // 见官方题解，可简化为一个循环
        while (start < S.length()) {

            int j = start;
            int maxEnd = start;
            while (j <= maxEnd && j <= S.length()) {

                int c = S.charAt(j) - 'a';
                int last = lastIndex[c];

                if (last > maxEnd) {
                    maxEnd = last;
                }
                j++;
            }

            ret.add(j - start);
            start = j;
        }
        return ret;
    }

    /**
     * 自己写的
     * <p>
     * 执行用时：16 ms, 在所有 Java 提交中击败了11.02%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了25.44%的用户
     */
    public List<Integer> partitionLabels2(String S) {

        List<Integer> ret = new ArrayList<>();
        if (S.length() <= 1) {
            ret.add(S.length());
            return ret;
        }

        List<List<Character>> elementList = new ArrayList<>();

        ret.add(1);
        List<Character> el = new ArrayList<>();
        el.add(S.charAt(0));

        elementList.add(el);

        for (int index = 1; index < S.length(); index++) {

            boolean exist = false;
            for (int elIndex = 0; elIndex < elementList.size(); elIndex++) {

                List<Character> element = elementList.get(elIndex);

                if (element.contains(S.charAt(index))) {
                    exist = true;

                    int sum = 1;
                    for (int retIndex = elIndex; retIndex < ret.size(); retIndex++) {
                        sum += ret.get(retIndex);
                        if (retIndex > elIndex) {
                            element.addAll(elementList.get(retIndex));
                        }
                    }
                    ret.set(elIndex, sum);

                    for (int retIndex = ret.size() - 1; retIndex > elIndex; retIndex--) {
                        elementList.remove(retIndex);
                        ret.remove(retIndex);
                    }

                    break;
                }
            }

            if (!exist) {

                ret.add(1);

                List<Character> newEl = new ArrayList<>();
                newEl.add(S.charAt(index));

                elementList.add(newEl);
            }

        }

        return ret;
    }
}
