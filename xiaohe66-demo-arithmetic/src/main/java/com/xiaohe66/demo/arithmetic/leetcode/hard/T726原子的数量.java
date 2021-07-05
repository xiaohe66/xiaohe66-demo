package com.xiaohe66.demo.arithmetic.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author xiaohe
 * @time 2021.07.05 11:21
 */
public class T726原子的数量 {

    LinkedList<Map<String, Integer>> stack;
    int begin;
    int end;
    int qty;
    String formula;
    boolean canNotAddElm;
    boolean canNotPop;

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了97.14%的用户
     * 内存消耗：37 MB, 在所有 Java 提交中击败了51.79%的用户
     */
    public String countOfAtoms(String formula) {

        stack = new LinkedList<>();
        stack.push(new TreeMap<>());

        canNotAddElm = true;
        canNotPop = true;
        this.formula = formula;

        int i = 0;
        while (i < formula.length()) {

            char c = formula.charAt(i);

            if (c == '(') {
                addElm();
                popMap();
                stack.push(new HashMap<>());

            } else if (c == ')') {
                addElm();
                popMap();

                canNotPop = false;
                qty = 0;

            } else if (c >= 'A' && c <= 'Z') {
                addElm();
                popMap();

                begin = i;
                end = i;
                qty = 0;

                canNotAddElm = false;

            } else if (c >= 'a' && c <= 'z') {
                end = i;

            } else {
                int q = c - '0';
                qty = qty * 10 + q;
            }

            i++;
        }
        addElm();
        popMap();

        // System.out.println(stack.getFirst().toString());

        StringBuilder ret = new StringBuilder();

        Set<Map.Entry<String, Integer>> entrySet = stack.getFirst().entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            ret.append(entry.getKey());
            if (entry.getValue() > 1) {
                ret.append(entry.getValue());
            }
        }

        return ret.toString();
    }

    private void addElm() {
        if (canNotAddElm) {
            return;
        }
        canNotAddElm = true;

        // 处理上一个元素
        String key = formula.substring(begin, end + 1);

        Map<String, Integer> map = stack.getFirst();

        if (qty == 0) {
            qty = 1;
        }

        // 未出现过数字，不为0，是为1
        map.put(key, map.getOrDefault(key, 0) + qty);
    }

    private void popMap() {
        if (canNotPop) {
            return;
        }


        /*
              括号后面复杂，存在以下多种情况
              括号+数字
              括号+大写字母
              括号+括号
         */
        canNotPop = true;
        Map<String, Integer> poll = stack.poll();
        Map<String, Integer> first = stack.getFirst();

        if (qty == 0) {
            qty = 1;
        }

        for (Map.Entry<String, Integer> entry : poll.entrySet()) {
            Integer origin = first.getOrDefault(entry.getKey(), 0);
            first.put(entry.getKey(), origin + entry.getValue() * qty);
        }
    }
}
