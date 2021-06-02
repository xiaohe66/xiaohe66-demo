package com.xiaohe66.demo.arithmetic.leetcode.hard;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 * <p>
 * |
 * |
 * |                            ||||
 * |            ||||xxxxxxxxxxxx||||||||xxxx||||
 * |    ||||xxxx||||||||xxxx||||||||||||||||||||||||
 * |------------------------------------------------
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（xxxx表示水）。
 *
 * <p>
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 通过次数13,157提交次数20,694
 *
 * @author xiaohe
 * @time 2021.04.02 10:47
 */
public class T面试题17_21直立方的水量 {

    /**
     * 思路：双指针
     * <p>
     * 特点：从侧面图来看，是一列一列进行累加的。
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.90%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了63.26%的用户
     */
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;

        while (left <= right) {

            if (rightMax > leftMax) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];

                } else {
                    sum = sum + leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    sum = sum + rightMax - height[right];
                }

                right--;
            }
        }

        return sum;
    }

    /**
     * 思路：用栈保存下标 i 。每1步遍历完后，都往栈中压入当前下标
     * 当栈为空时，或 height[i] <= height[i-1]时，直接把 i 压入栈。
     * 当遍历到一个值 height[i] > height[i-1] 时，便构成了一个可存放水量的下凹处。
     * 这时出栈取出下标 x，直至 height[x] >= height[i] 或栈为空。
     * 累加到总水量为 ： (i - x - 1) * (min(height[x],height[i])- height[上一个x])
     * <p>
     * 特点：从侧面图来看，累加时，是从最下面一层往上累加的。
     *
     * <p>
     * 执行用时：3 ms, 在所有 Java 提交中击败了29.32%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了50.05%的用户
     */
    public int trap3(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int sum = 0;
        for (int i = 1; i < height.length; i++) {

            if (height[i - 1] < height[i]) {

                int h = stack.pop();
                while (!stack.isEmpty()) {
                    int index = stack.peek();

                    sum += (i - index - 1) * (Math.min(height[i], height[index]) - height[h]);

                    if (height[index] <= height[i]) {
                        h = stack.pop();
                    } else {
                        break;
                    }
                }

            }
            stack.push(i);
        }

        return sum;
    }


    /**
     * 思路：找到每个高的顶点，再计算顶点之间的数量
     *
     * <p>
     * 执行用时：3 ms, 在所有 Java 提交中击败了29.32%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了85.34%的用户
     */
    public int trap2(int[] height) {

        if (height.length <= 2) {
            return 0;
        }

        LinkedList<Integer> linkedList = findPeak(height);

        if (linkedList.size() == 1) {
            return 0;
        }

        int sum = 0;

        int prevPeak = linkedList.poll();
        while (!linkedList.isEmpty()) {
            int curPeak = linkedList.poll();

            int min = Math.min(height[prevPeak], height[curPeak]);
            sum += (curPeak - prevPeak - 1) * min;

            for (int i = prevPeak + 1; i < curPeak; i++) {
                sum -= Math.min(height[i], min);
            }
            prevPeak = curPeak;
        }

        return sum;
    }

    public LinkedList<Integer> findPeak(int[] height) {
        LinkedList<Integer> peakList = new LinkedList<>();

        peakList.add(0);

        int maxIndex = 0;

        for (int i = 1; i < height.length; i++) {

            if (height[i] > height[i - 1]) {

                if (height[maxIndex] >= height[i]) {
                    while (height[peakList.getLast()] < height[i]) {
                        peakList.removeLast();
                    }

                } else {
                    while (peakList.getLast() != maxIndex) {
                        peakList.removeLast();
                    }
                }

                if (peakList.getLast() == i - 1) {
                    peakList.removeLast();
                }

                if (height[maxIndex] <= height[i]) {
                    maxIndex = i;
                }

                peakList.add(i);
            }
        }
        return peakList;
    }

}
