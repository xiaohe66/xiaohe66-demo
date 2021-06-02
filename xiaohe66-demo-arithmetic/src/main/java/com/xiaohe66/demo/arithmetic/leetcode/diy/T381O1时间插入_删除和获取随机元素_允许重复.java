package com.xiaohe66.demo.arithmetic.leetcode.diy;

import java.util.Random;

/**
 * 难度：困难
 * <p>
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 * <p>
 * 注意: 允许出现重复元素。
 * <p>
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 *
 * @author xiaohe
 * @time 2020.10.31 11:38
 */
public class T381O1时间插入_删除和获取随机元素_允许重复 {


    public static class RandomizedCollection {

        private Random random = new Random();

        int[] table = new int[10];
        private int size = 0;

        public boolean insert(int val) {

            boolean ret;
            int i = -1;

            int low = 0;
            int high = size - 1;
            while (true) {

                if (low > high) {
                    i = high + 1;
                    ret = true;
                    break;
                }

                int middle = (low + high) / 2;

                if (val == table[middle]) {
                    i = middle + 1;
                    ret = false;
                    break;
                }

                if (val > table[middle]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }

            }

            size++;

            if (size >= table.length) {
                int max = size / 2 + size;
                int[] newTable = new int[max];

                System.arraycopy(table, 0, newTable, 0, i);
                System.arraycopy(table, i, newTable, i + 1, size - i);
                newTable[i] = val;
                table = newTable;

            } else {

                System.arraycopy(table, i, table, i + 1, size - i);
                table[i] = val;
            }


            return ret;
        }

        public boolean remove(int val) {

            int i = -1;
            int low = 0;
            int high = size - 1;
            while (low <= high) {
                int middle = (low + high) / 2;
                if (val == table[middle]) {
                    i = middle;
                    break;
                }
                if (val > table[middle]) {
                    low = middle + 1;
                }
                if (val < table[middle]) {
                    high = middle - 1;
                }
            }

            if (i < 0) {
                return false;
            }

            size--;
            if (i < size) {
                System.arraycopy(table, i + 1, table, i, size - i);
            }

            return true;
        }

        public int getRandom() {
            return table[random.nextInt(size)];
        }

        @Override
        public String toString() {
            if (size == 0) {
                return "[]";
            }
            StringBuilder str = new StringBuilder(size + 3);
            str.append('[');
            str.append(table[0]);
            for (int i = 1; i < size; i++) {
                str.append(',').append(table[i]);
            }
            str.append(']');
            return str.toString();
        }
    }


}

/**
 * 题目提供的类结构
 */
class RandomizedCollection {

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {

    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        return false;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        return false;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return 0;
    }
}