package com.xiaohe66.demo.bihu;

/**
 * 打印1到1000之间包含数字9的数 (比如9, 19, 199, 920 都算)
 *
 * 解题思路：
 * 1.获取int的String形式
 * 2.遍历每一位，获取到char的值
 * 3.与'9'进行匹配，结果为true表示该数包含9
 *
 *
 * @author xh
 * @date 17-12-24 024
 */
public class Demo1 {

    public static void main(String[] args) {
        int n = 999;
        //遍历9-999
        for (int i = 9; i <= n; i++) {
            //获取int的String表现形式
            String str = String.valueOf(i);
            //遍历每一位，获取char
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                //若有一位是9，则表示该数包含9
                if('9'==c){
                    System.out.println(i);
                    //跳出当前循环
                    break;
                }
            }
        }
    }

}
