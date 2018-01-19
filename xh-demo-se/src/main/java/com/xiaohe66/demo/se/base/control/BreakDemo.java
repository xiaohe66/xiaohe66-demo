package com.xiaohe66.demo.se.base.control;

/**
 * @author xh
 * @date 2017-12-13
 *
 * 在循环体中，中断基本分为以下几种
 * 1、continue:单次跳出
 * 2、break:跳出当前循环体、或跳出多层循环体
 * 3、return:直接中断
 */
public class BreakDemo {

    public static void main(String[] args) {
        for(int i=0;i<=9;i++){
            if(i==3||i==6){
                //单次跳出
                continue;
            }
            if(i==8){
                //跳出当前的整个循环体
                break;
            }
            System.out.println("当前的值是:"+i);
        }

        name:for(int i =0;i<5;i++){
            for(int j=0;j<5;j++){
                if(i==4&&j==3){
                    //跳出多层循环
                    break name;
                }
                System.out.println("i="+i+",j="+j);
            }
        }

        for(int i =0;i<9;i++){
            if(i==8){
                //使用return后，直接中断后续的程序代码
                return;
            }
            System.out.println("值为："+i);
        }

    }

}
