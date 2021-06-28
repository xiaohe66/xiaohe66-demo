package com.xiaohe66.demo.arithmetic.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 *
 * <p>
 * 示例 1：
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 *
 * <p>
 * 示例 2：
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 *  
 * <p>
 * 提示：
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 *
 * <p>
 * 通过次数13,810提交次数36,239
 *
 * @author xiaohe
 * @time 2021.06.28 10:51
 */
public class T815公交路线 {

    /**
     * 执行用时：49 ms, 在所有 Java 提交中击败了64.01%的用户
     * 内存消耗：63.1 MB, 在所有 Java 提交中击败了51.08%的用户
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> standCarMap = new HashMap<>();

        for (int car = 0; car < routes.length; car++) {

            for (int stand : routes[car]) {

                List<Integer> list = standCarMap.computeIfAbsent(stand, k -> new ArrayList<>());
                list.add(car);
            }
        }

        List<Integer> carList = standCarMap.get(source);
        if (carList == null) {
            return -1;
        }

        LinkedList<Integer> carQueue = new LinkedList<>(carList);
        Set<Integer> carExist = new HashSet<>(carList);

        int step = 1;

        while (!carQueue.isEmpty()) {

            int size = carQueue.size();

            for (int i = 0; i < size; i++) {

                Integer car = carQueue.poll();

                for (int stand : routes[car]) {

                    if (stand == target) {
                        return step;
                    }

                    carList = standCarMap.get(stand);
                    if (carList != null) {

                        for (Integer car2 : carList) {
                            if (!carExist.contains(car2)) {

                                carQueue.add(car2);
                                carExist.add(car2);
                            }
                        }
                    }
                }
            }

            step++;
        }

        return -1;
    }
}
