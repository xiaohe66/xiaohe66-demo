package com.xiaohe66.demo.arithmetic.leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author xiaohe
 * @time 2021.07.06 11:10
 */
public class T1418点菜展示表 {

    /**
     * 执行用时：26 ms, 在所有 Java 提交中击败了95.18%的用户
     * 内存消耗：47.6 MB, 在所有 Java 提交中击败了75.90%的用户
     */
    public List<List<String>> displayTable(List<List<String>> orders) {

        Map<String, Integer>[] qtyMapArr = new Map[501];
        for (int i = 0; i < qtyMapArr.length; i++) {
            qtyMapArr[i] = new HashMap<>();
        }

        Map<String, Integer> indexMap = new TreeMap<>();

        for (List<String> order : orders) {

            int i = Integer.parseInt(order.get(1));
            String name = order.get(2);

            Integer qty = qtyMapArr[i].getOrDefault(name, 0);
            qtyMapArr[i].put(name, qty + 1);

            if (!indexMap.containsKey(name)) {
                indexMap.put(name, 0);
            }
        }

        int index = 1;
        for (Map.Entry<String, Integer> entry : indexMap.entrySet()) {
            entry.setValue(index);
            index++;
        }

        int len = indexMap.size() + 1;
        List<List<String>> ansList = new ArrayList<>();

        List<String> tmp = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            tmp.add("0");
        }

        ansList.add(tmp);

        for (int i = 0; i < qtyMapArr.length; i++) {

            if (qtyMapArr[i].size() == 0) {
                continue;
            }

            Set<Map.Entry<String, Integer>> entrySet = qtyMapArr[i].entrySet();

            List<String> list = new ArrayList<>(tmp);
            ansList.add(list);

            list.set(0, String.valueOf(i));

            for (Map.Entry<String, Integer> entry : entrySet) {

                Integer j = indexMap.get(entry.getKey());
                list.set(j, String.valueOf(entry.getValue()));
            }
        }

        int i = 1;
        for (Map.Entry<String, Integer> entry : indexMap.entrySet()) {

            tmp.set(i, entry.getKey());
            i++;
        }

        tmp.set(0, "Table");

        return ansList;
    }
}
