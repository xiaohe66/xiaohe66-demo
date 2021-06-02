package com.xiaohe66.demo.arithmetic.leetcode.other;

/**
 * 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 *
 * <p>
 * 请你实现 ParkingSystem 类：
 *
 * <p>
 * ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，三个参数分别对应每种停车位的数目。
 * bool addCar(int carType) 检查是否有 carType 对应的停车位。 carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。
 * 一辆车只能停在  carType 对应尺寸的停车位中。如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 。
 *  
 * <p>
 * 示例 1：
 * 输入：
 * ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
 * [[1, 1, 0], [1], [2], [3], [1]]
 * 输出：
 * [null, true, true, false, false]
 *
 * <p>
 * 解释：
 * ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
 * parkingSystem.addCar(1); // 返回 true ，因为有 1 个空的大车位
 * parkingSystem.addCar(2); // 返回 true ，因为有 1 个空的中车位
 * parkingSystem.addCar(3); // 返回 false ，因为没有空的小车位
 * parkingSystem.addCar(1); // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
 *  
 * <p>
 * 提示：
 * 0 <= big, medium, small <= 1000
 * carType 取值为 1， 2 或 3
 * 最多会调用 addCar 函数 1000 次
 *
 * <p>
 * 通过次数22,124提交次数25,854
 *
 * @author xiaohe
 * @time 2021.03.19 09:57
 */
public class T1603设计停车系统 {


    /**
     * 执行用时：11 ms, 在所有 Java 提交中击败了36.28%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了58.69%的用户
     */
    public static class ParkingSystem {

        private final int[] arr;

        public ParkingSystem(int big, int medium, int small) {
            arr = new int[]{big, medium, small};
        }

        public boolean addCar(int carType) {
            int i = carType - 1;
            if (arr[i] > 0) {
                arr[i]--;
                return true;
            }
            return false;
        }
    }

    /**
     * 执行用时：10 ms, 在所有 Java 提交中击败了96.81%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了11.36%的用户
     */
    public static class ParkingSystem2 {

        private final int[] arr;

        public ParkingSystem2(int big, int medium, int small) {
            arr = new int[]{0, big, medium, small};
        }

        public boolean addCar(int carType) {
            if (arr[carType] > 0) {
                arr[carType]--;
                return true;
            }
            return false;
        }
    }
}
