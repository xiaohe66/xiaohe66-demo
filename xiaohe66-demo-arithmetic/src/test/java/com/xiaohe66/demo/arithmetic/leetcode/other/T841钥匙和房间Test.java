package com.xiaohe66.demo.arithmetic.leetcode.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class T841钥匙和房间Test {


    T841钥匙和房间 demo = new T841钥匙和房间();

    @Test
    public void test1() {

        assertTrue(demo.canVisitAllRooms(Arrays.asList(
                Collections.singletonList(1),
                Collections.singletonList(2),
                Collections.singletonList(3),
                Collections.emptyList()
        )));

        assertFalse(demo.canVisitAllRooms(Arrays.asList(
                Arrays.asList(1,3),
                Arrays.asList(3,0,1),
                Arrays.asList(2),
                Arrays.asList(0)
        )));
    }
}