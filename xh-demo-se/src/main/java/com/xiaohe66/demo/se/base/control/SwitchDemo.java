package com.xiaohe66.demo.se.base.control;

import java.util.Scanner;

/**
 * @author xh
 * @date 2017-12-10
 *
 * switch 选择控制语句
 */
public class SwitchDemo {

    public static void main(String[] args) {
        //得到从键盘输入的一个值
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        //switch(值)该值只能是基本类型，在jdk1.7之后，加入了String类型
        switch (i){
            //用case表示多个与之匹配的值
            case 1:
                System.out.println("输入的是1");
                //在匹配到一个之后，若不加break，则代码会继续往后执行
                //break;
            case 2:
                System.out.println("输入的是2");
                break;
            default:
                System.out.println("输入了其它");
                break;
        }

    }
}
