package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class T77组合Test {

    T77组合 demo = new T77组合();

    @Test
    public void test1() {

        Set<Set<Integer>> set1 = toSet(Arrays.asList(
                Arrays.asList(2, 4),
                Arrays.asList(3, 4),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4)
        ));

        Set<Set<Integer>> set2 = toSet(demo.combine(4, 2));
        System.out.println("set1 : "+set1);
        System.out.println("set2 : "+set2);

        assertEquals(set1,set2);
    }

    @Test
    public void test2() {

        Set<Set<Integer>> set1 = toSet(Arrays.asList(
                Arrays.asList(1))
        );

        Set<Set<Integer>> set2 = toSet(demo.combine(1, 1));
        System.out.println("set1 : "+set1);
        System.out.println("set2 : "+set2);

        assertEquals(set1,set2);
    }

    @Test
    public void test3() {

        Set<Set<Integer>> set1 = toSet(Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2)
        ));

        Set<Set<Integer>> set2 = toSet(demo.combine(2, 1));
        System.out.println("set1 : "+set1);
        System.out.println("set2 : "+set2);

        assertEquals(set1,set2);
    }

    private boolean isSame(List<List<Integer>> list1, List<List<Integer>> list2) {
        return toSet(list1).equals(toSet(list2));
    }

    private Set<Set<Integer>> toSet(List<List<Integer>> list) {
        return list.stream().map(HashSet::new).collect(Collectors.toSet());
    }
}