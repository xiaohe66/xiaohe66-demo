package com.xiaohe66.demo.arithmetic.math;

/**
 * 递归求知
 * n + (n-1) + ... + (n-2)+ 1
 *
 * @author xiaohe
 * @date 2019.05.08 13:20
 */
public class Recursion1 {

    int sum(int n){

        if(n > 1){
            return sum(n-1)+n;
        }else{
            return 1;
        }
    }

    public static void main(String[] args) {

        System.out.println(new Recursion1().sum(4));

    }

}
