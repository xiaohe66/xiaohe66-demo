package com.xiaohe66.demo.arithmetic.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 *
 * <p>
 * 返回森林中兔子的最少数量。
 *
 * <p>
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * <p>
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * <p>
 * 输入: answers = []
 * 输出: 0
 *
 * <p>
 * 说明:
 * answers 的长度最大为1000。
 * answers[i] 是在 [0, 999] 范围内的整数。
 *
 * <p>
 * 通过次数35,086提交次数55,579
 *
 * @author xiaohe
 * @time 2021.04.09 16:47
 */
public class T781森林中的兔子 {

    /*
     * 看了官方题解后
     * 原本自己在思考时，得出同种数量的颜色个数公式为：(qty - 1)/(num+1) + 1，其实可以变成 向上取整(qty / (num+1)) 的方式
     *
     * 看了负雪明烛的题解后，知道 向上取整(qty/(num+1)) <==> (qty+num)/(num+1)   牛批 ~
     *
     * */

    /**
     * 思路，先排序。
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了94.66%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了42.45%的用户
     */
    public int numRabbits(int[] answers) {

        if (answers.length == 0) {
            return 0;
        }

        Arrays.sort(answers);

        int start = 0;
        int sum = 0;
        int next;
        int i = 0;

        while (i < answers.length - 1) {

            next = i + 1;

            if (answers[i] != answers[next]) {
                int qty = next - start;
                int num = answers[start] + 1;
                sum += (qty - 1) / num * num + num;
                start = next;
            }

            i = next;
        }

        if (answers[i] == answers[start]) {
            int qty = answers.length - start;
            int num = answers[start] + 1;
            sum += (qty - 1) / num * num + num;
        } else {
            int qty = i - start;
            int num = answers[start] + 1;
            sum += (qty - 1) / num * num + num;

            sum += answers[i] + 1;
        }

        return sum;
    }

    /**
     * 思路：
     * 设：数量为 num，此次为qty，则当 qty >num+1 时，存在不止一种颜色。颜色个数为：(qty - 1)/(num+1) + 1
     * 记录每1种数量的个数，即可算出最小值
     * <p>
     * <p
     * 执行用时：3 ms, 在所有 Java 提交中击败了68.56%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了5.10%的用户
     */
    public int numRabbits2(int[] answers) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : answers) {
            Integer qty = map.get(num);
            if (qty == null) {
                map.put(num, 1);
            } else {
                map.put(num, qty + 1);
            }
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int qty = entry.getValue();

            if (qty > num + 1) {
                sum += (qty + num) / (num + 1) * (num + 1);
            } else {
                sum += num + 1;
            }

        }

        return sum;
    }

}
