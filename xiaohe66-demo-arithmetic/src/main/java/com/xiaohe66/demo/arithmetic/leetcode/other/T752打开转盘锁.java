package com.xiaohe66.demo.arithmetic.leetcode.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 *  
 * <p>
 * 示例 1:
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * <p>
 * 示例 2:
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * <p>
 * 示例 3:
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * <p>
 * 示例 4:
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 * <p>
 * 通过次数50,668提交次数98,549
 *
 * @author xiaohe
 * @time 2021.06.25 13:43
 */
public class T752打开转盘锁 {


    /**
     * 来自 宫水三叶 的思路，自己编码：
     * 双向同时遍历：
     * 执行用时：17 ms, 在所有 Java 提交中击败了99.94%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了87.22%的用户
     */
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> ban = new HashSet<>();
        Collections.addAll(ban, deadends);

        if (ban.contains("0000")) {
            return -1;
        }

        Set<String> cache1 = new HashSet<>();
        cache1.add("0000");

        LinkedList<String> sur1 = new LinkedList<>();
        sur1.add("0000");

        Set<String> cache2 = new HashSet<>();
        cache2.add(target);

        LinkedList<String> sur2 = new LinkedList<>();
        sur2.add(target);

        int step1 = 0;
        int step2 = 0;

        List<String> tmp = new ArrayList<>(8);


        while (!sur1.isEmpty() && !sur2.isEmpty()) {

            step1++;
            if (help(ban, cache1, sur1, cache2, tmp)) {
                return step1 + step2;
            }

            step2++;
            if (help(ban, cache2, sur2, cache1, tmp)) {
                return step1 + step2;
            }
        }

        return -1;
    }

    private boolean help(Set<String> ban, Set<String> cache, LinkedList<String> sur, Set<String> other, List<String> tmp) {
        int size = sur.size();
        for (int i = 0; i < size; i++) {

            tmp.clear();
            getNextList(tmp, sur.pop());

            for (String next : tmp) {

                if (!ban.contains(next) && !cache.contains(next)) {

                    if (other.contains(next)) {
                        return true;
                    }

                    sur.add(next);
                    cache.add(next);
                }
            }

        }
        return false;
    }


    /**
     * 来自官方题解的思路，自己编码：
     * 执行用时：92 ms, 在所有 Java 提交中击败了81.57%的用户
     * 内存消耗：42.6 MB, 在所有 Java 提交中击败了82.58%的用户
     */
    public int openLock2(String[] deadends, String target) {

        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> ban = new HashSet<>();
        Collections.addAll(ban, deadends);

        if (ban.contains("0000")) {
            return -1;
        }

        Set<String> cache = new HashSet<>();
        cache.add("0000");

        LinkedList<String> sur = new LinkedList<>();
        sur.add("0000");

        int step = 0;
        List<String> nextList = new ArrayList<>(8);

        while (!sur.isEmpty()) {

            step++;
            int size = sur.size();

            for (int i = 0; i < size; i++) {

                nextList.clear();
                getNextList(nextList, sur.pop());

                for (String next : nextList) {
                    if (!ban.contains(next) && !cache.contains(next)) {

                        if (next.equals(target)) {
                            return step;
                        }

                        cache.add(next);
                        sur.add(next);
                    }
                }
            }
        }

        return -1;
    }

    private void getNextList(List<String> tmp, String num) {

        char[] chars = num.toCharArray();

        tmp.add(getPrev(chars, 0));
        tmp.add(getPrev(chars, 1));
        tmp.add(getPrev(chars, 2));
        tmp.add(getPrev(chars, 3));

        tmp.add(getNext(chars, 0));
        tmp.add(getNext(chars, 1));
        tmp.add(getNext(chars, 2));
        tmp.add(getNext(chars, 3));
    }

    private String getPrev(char[] chars, int i) {
        char c = chars[i];
        chars[i] = c == '0' ? '9' : (char) (c - 1);
        String ret = new String(chars);
        chars[i] = c;
        return ret;
    }

    private String getNext(char[] chars, int i) {
        char c = chars[i];
        chars[i] = c == '9' ? '0' : (char) (c + 1);
        String ret = new String(chars);
        chars[i] = c;
        return ret;
    }
}
