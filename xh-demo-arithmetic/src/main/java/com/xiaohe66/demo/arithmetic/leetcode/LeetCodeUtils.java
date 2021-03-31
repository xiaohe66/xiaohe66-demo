package com.xiaohe66.demo.arithmetic.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xiaohe
 * @time 2020.09.09 14:46
 */
public class LeetCodeUtils {

    private LeetCodeUtils() {

    }

    public static boolean equalsList(List<?> list1, List<?> list2) {

        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);

        if (list1 == list2) {
            return true;
        }

        if (list1.size() != list2.size()) {
            return false;
        }

        Set<?> set1 = new HashSet<>(list1);
        if (set1.size() != list1.size()) {
            return false;
        }

        Set<?> set2 = new HashSet<>(list2);
        if (set2.size() != list2.size()) {
            return false;
        }

        return set1.equals(set2);
    }
}
