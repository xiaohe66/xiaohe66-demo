package com.xiaohe66.demo.arithmetic.math;

/**
 *
 * 不使用数据类库，求Sqrt(2)的值，精确到小数点后10位
 *
 * @author xiaohe
 * @time 2019.07.18 15:24
 */
public class Sqrt2 {


    public static void main(String[] args) {

        int value = 2;

        double correctSqrt = Math.sqrt(value);

        double currentSqrtMin = 1;
        double currentSqrtMax = 2;

        int times = 0;
        while (times++ < 60) {
            double currentSqrt = (currentSqrtMax + currentSqrtMin )/2.0;
            double newSqrt = currentSqrt * currentSqrt;
            if(newSqrt > value){
                currentSqrtMax = currentSqrt;
            }else {
                currentSqrtMin = currentSqrt;
            }
            System.out.println(correctSqrt +"\t"+currentSqrt+"\t"+ times);
        }


    }

}
