package com.xiaohe66.demo.arithmetic.math;

/**
 * 若length 是2的 n 次方，则 n%length == n&(length-1)，而按位运算速度更快
 *
 * @author xiaohe
 * @time 2019.11.22 10:31
 */
public class DividedTwo {

    private static void test1(long n, int divisor) {
        long a = n % divisor;
        long b = n & (divisor - 1);
        if (a != b) {
            System.out.println(String.format("=%s,%s", a, b));
        }
    }

    private static void test2(long n, int divisor) {
        long a = n % divisor;
    }

    private static void test3(long n, int divisor) {
        long b = n & (divisor - 1);
    }


    public static void main(String[] args) {

        long n = 100L * 10000 * 10000;
        int divisor = 8;

//        for (int i = 0; i < n; i++) {
//            test1(i, divisor);
//        }

        long time1 = System.currentTimeMillis();
        for (long i = 0; i < n; i++) {
            test2(i, divisor);
        }
        long time2 = System.currentTimeMillis();
        for (long i = 0; i < n; i++) {
            test3(i, divisor);
        }
        long time3 = System.currentTimeMillis();

        long gap1 = time2 - time1;
        long gap2 = time3 - time2;

        // NOTE : 这个结果是错的，如果更换 test2 和 test3 的测试顺序，会产生相反的结果。
        System.out.println(String.format("取余花费:%s,按位花费:%s,按位是否更省时间：%s", gap1, gap2, gap1 > gap2));


    }

}
