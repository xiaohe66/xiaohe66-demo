package com.xiaohe66.demo.arithmetic.leetcode.hard;

import com.xiaohe66.demo.arithmetic.leetcode.LeetCodeUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ClassPathUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class T815公交路线Test {

    private T815公交路线 demo = new T815公交路线();

    @Test
    public void test1() {

        assertEquals(-1, demo.numBusesToDestination(LeetCodeUtils.stringToArr2("[[1],[2]]"), 1, 2));

        assertEquals(1, demo.numBusesToDestination(LeetCodeUtils.stringToArr2("[[1,2,3]]"), 1, 3));
        assertEquals(-1, demo.numBusesToDestination(LeetCodeUtils.stringToArr2("[[1,2,3]]"), 1, 4));

        assertEquals(5, demo.numBusesToDestination(LeetCodeUtils.stringToArr2("[[211,85],[1,2,7],[3,6,7,8,9,10,25,367],[499,399,200,211],[367,499]]"), 1, 85));

        assertEquals(-1, demo.numBusesToDestination(LeetCodeUtils.stringToArr2("[[1,2,3],[3,2,1]]"), 1, 4));
        assertEquals(0, demo.numBusesToDestination(LeetCodeUtils.stringToArr2("[[1,2,3],[3,2,1]]"), 4, 4));

        assertEquals(2, demo.numBusesToDestination(LeetCodeUtils.stringToArr2("[[1,2,7],[3,6,7]]"), 1, 6));
        assertEquals(-1, demo.numBusesToDestination(new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}}, 15, 12));
    }


    @Test
    public void test2() throws IOException {


        String str = LeetCodeUtils.readClassPathFile(getClass(), "T815公交路线Test_test2.txt");

        System.out.println(str);
        int[][] arr = LeetCodeUtils.stringToArr2(str);
        assertEquals(0, demo.numBusesToDestination(arr, 0, 100000));

    }
}