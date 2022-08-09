package com.xiaohe66.demo.se.common;

import java.math.BigDecimal;

/**
 * @author xiaohe
 * @time 2019.06.04 15:52
 */
public class BigDecimalDemo {

    public static void main(String[] args) {


        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("3");

        // ROUND_DOWN 退一法
        System.out.println(a.divide(b, 0, BigDecimal.ROUND_DOWN));
        System.out.println(a.divide(b, 1, BigDecimal.ROUND_DOWN));
        System.out.println(a.divide(b, 2, BigDecimal.ROUND_DOWN));

        // ROUND_UP 进一法
        System.out.println(a.divide(b, 0, BigDecimal.ROUND_UP));
        System.out.println(a.divide(b, 1, BigDecimal.ROUND_UP));
        System.out.println(a.divide(b, 2, BigDecimal.ROUND_UP));

    }

}
