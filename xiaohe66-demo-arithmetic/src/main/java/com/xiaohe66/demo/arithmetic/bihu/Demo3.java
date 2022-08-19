package com.xiaohe66.demo.arithmetic.bihu;

import java.util.Scanner;

/**
 * 通过接受键盘输入的数字打印出星期几, 比如输入0打印星期天,1打印星期1,输入7的时候又打印星期天
 *
 * 基本思路
 * 1.对输入的数进行取余，最终得到1-7范围的值，就可以进行输出
 * 2.得到的余数可能是负数或为0，这时只要使其加7便可
 *
 * todo:输入的值超过long的最大值或最小值时，将出现问题
 *
 * @author xh
 * @date 17-12-24 024
 */
public class Demo3 {

    public static void main(String[] args) {
        //创建scanner对象
        Scanner scanner = new Scanner(System.in);
        //提示输入
        System.out.println("输入一个自然数后按回车:");
        //获取输入的值
        long n = scanner.nextInt();
        //对输入的值进行取余操作
        long week = n%7;
        //若余数为负数或0，则加7
        if(week<=0){
            week+=7;
        }

        if(week == 7){
            //输出星期天
            System.out.println("星期天");
        }else{
            //输出其它星期
            System.out.println("星期"+week);
        }
    }
}
