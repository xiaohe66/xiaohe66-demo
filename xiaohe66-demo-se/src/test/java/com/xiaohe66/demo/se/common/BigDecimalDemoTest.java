package com.xiaohe66.demo.se.common;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemoTest {

    @Test
    public void test1() {

        BigDecimal a = new BigDecimal(0.01);
        BigDecimal b = BigDecimal.valueOf(0.01);

        // 精度丢失
        System.out.println("a = " + a);
        // 正确
        System.out.println("b = " + b);
    }

    @Test
    public void test2() {
        BigDecimal a = new BigDecimal("0.01");
        BigDecimal b = new BigDecimal("0.010");

        // 当值的精度不相同时, equals 将返回 false
        System.out.println(a.equals(b));

        // 在比较值的大小时，应该使用 compareTo() 方法, -1（小于），0（等于），1（大于）
        System.out.println(a.compareTo(b));
    }

    @Test
    public void test3() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("3.0");

        System.out.println(a.divide(b, RoundingMode.HALF_UP));

        // 结果是个循环小数，但因未设置精度，所以会抛出异常
        System.out.println(a.divide(b));
    }

    @Test
    public void test4() {

        BigDecimal a = BigDecimal.valueOf(35634535255456719.22345634534124578902);

        // 有的时候，会按科学计数法进行输出。
        System.out.println(a.toString());

        // 平常使用时，应该使用这个方法
        System.out.println(a.toPlainString());
    }

}
