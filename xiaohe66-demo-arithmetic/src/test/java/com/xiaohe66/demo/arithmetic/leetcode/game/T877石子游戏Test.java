package com.xiaohe66.demo.arithmetic.leetcode.game;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class T877石子游戏Test {

    private T877石子游戏 demo = new T877石子游戏();

    @Test
    public void test1() {

        assertTrue(demo.stoneGame(new int[]{3, 5}));
        assertTrue(demo.stoneGame(new int[]{5, 3}));
        assertTrue(demo.stoneGame(new int[]{5, 3, 4, 5}));
    }

}