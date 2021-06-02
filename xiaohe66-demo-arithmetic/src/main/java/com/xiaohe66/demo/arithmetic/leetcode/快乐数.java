package com.xiaohe66.demo.arithmetic.leetcode;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False
 *
 * <p>示例
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * @author xiaohe
 * @time 2020.04.30 14:35
 */
public class 快乐数 {


    static int[] squareArr = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};

    static int run(int num) {

        int scale = 10;
        int sum = 0;

        do {
            int index = num % scale;
            System.out.print(index);
            System.out.print(',');
            sum += squareArr[index];
            num = num / scale;

        } while (num > 0);

        return sum;
    }

    static boolean isHappy(int n) {

        if (n < 1) {
            return false;
        }

        while (n != 1) {

            boolean isExit = n == 20 || n == 4 || n == 16 || n == 37 || n == 58 || n == 89 || n == 145 || n == 42;

            if (isExit) {
                return false;
            }

            n = run(n);

            System.out.println(n);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        return true;
    }


    public static void main(String[] args) {

        isHappy(1563712132);
        isHappy2(1563712132);

    }

    //参考英文网站热评第一。这题可以用快慢指针的思想去做，有点类似于检测是否为环形链表那道题
    //如果给定的数字最后会一直循环重复，那么快的指针（值）一定会追上慢的指针（值），也就是
    //两者一定会相等。如果没有循环重复，那么最后快慢指针也会相等，且都等于1。
    public static boolean isHappy2(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
            System.out.print(slow);
            System.out.print(',');
            System.out.println(fast);
        } while (slow != fast);

        return fast == 1;
    }

    private static int squareSum(int m) {
        int squaresum = 0;
        while (m != 0) {
            squaresum += (m % 10) * (m % 10);
            m /= 10;
        }
        return squaresum;
    }

}
