package com.xiaohe66.demo.se.base;

import java.math.BigDecimal;

/**
 * 浮点数运算存在精度问题
 *
 * <p>加减乘除均存在精度问题，可使用 {@link BigDecimal} 类运行，可避免该情况
 *
 * @author xiaohe
 * @time 2019-02-12 10:38
 */
public class FloatingNumber {

	public static void main(String[] args) {
		System.out.println(1.1+0.1);
		System.out.println(BigDecimal.valueOf(1.1).add(BigDecimal.valueOf(0.1)).doubleValue());
		System.out.println("-------------------------------------------------------");

		System.out.println(1.0-0.9);
		System.out.println(BigDecimal.valueOf(1.0).subtract(BigDecimal.valueOf(0.9)).doubleValue());
		System.out.println("-------------------------------------------------------");

		System.out.println(3.0*1.1);
		System.out.println(BigDecimal.valueOf(3.0).multiply(BigDecimal.valueOf(1.1)).doubleValue());
		System.out.println("-------------------------------------------------------");

		System.out.println(9.999/1000.0);
		System.out.println(BigDecimal.valueOf(9.999).divide(BigDecimal.valueOf(1000.0)).doubleValue());

	}
}
