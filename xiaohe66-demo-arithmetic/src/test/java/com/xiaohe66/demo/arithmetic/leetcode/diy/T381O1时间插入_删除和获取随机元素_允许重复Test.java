package com.xiaohe66.demo.arithmetic.leetcode.diy;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T381O1时间插入_删除和获取随机元素_允许重复Test {

    T381O1时间插入_删除和获取随机元素_允许重复.RandomizedCollection collection
            = new T381O1时间插入_删除和获取随机元素_允许重复.RandomizedCollection();

    @Test
    public void test0() {


        Random random = new Random();
        for (int i = 0; i < 10; i++) {

            System.out.println(random.nextInt(2));
        }

    }

    @Test
    public void test1() {

        boolean ret;
        int val;

        // 向集合中插入 1 。返回 true 表示集合不包含 1 。
        ret = collection.insert(1);
        assertTrue(ret);
        assertArrayEquals(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, collection.table);

        // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
        ret =collection.insert(1);
        assertFalse(ret);
        assertArrayEquals(new int[]{1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, collection.table);

        // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
        ret =collection.insert(2);
        assertTrue(ret);
        assertArrayEquals(new int[]{1, 1, 2, 0, 0, 0, 0, 0, 0, 0}, collection.table);

        // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
        int subCount = 0;
        for (int i = 0; i < 10000; i++) {
            val = collection.getRandom();
            if(val == 1){
                subCount++;
            }else{
                subCount--;
            }

        }

        // 输出结果若近似与 10000 的三分之一，则说明概率相同
        System.out.println(subCount);


        // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
        ret = collection.remove(2);
        assertTrue(ret);
        assertEquals("[1,1]", collection.toString());

        ret = collection.insert(5);
        assertTrue(ret);
        assertEquals("[1,1,5]", collection.toString());

        ret = collection.insert(4);
        assertTrue(ret);
        assertEquals("[1,1,4,5]", collection.toString());
    }
}