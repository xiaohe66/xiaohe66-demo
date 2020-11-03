package com.xiaohe66.demo.arithmetic.my;

/**
 * 二分法有序插入
 *
 * @author xiaohe
 * @time 2020.11.03 15:20
 */
public class BinaryInsert {

    public void add(int[] nums, int num, int low, int high) {

        int end = high;
        int middle;

        while (high > low) {

            middle = (low + high) / 2;

            if (num < nums[middle]) {

                high = middle - 1;
            } else {

                low = middle + 1;
            }
        }

        // 保证复制的元素数量 大于 1
        if (end > low) {

            if (high == low && nums[low] < num) {
                low++;
            }

            System.arraycopy(nums, low, nums, low + 1, end - low);
        }

        nums[low] = num;
    }

}
