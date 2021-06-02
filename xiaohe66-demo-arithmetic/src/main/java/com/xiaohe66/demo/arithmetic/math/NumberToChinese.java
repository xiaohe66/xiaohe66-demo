package com.xiaohe66.demo.arithmetic.math;

/**
 * 传入一个千亿以内的数，将其转为中文表示
 *
 * @author xiaohe
 * @time 2019.07.18 15:27
 */
public class NumberToChinese {

    public static int length(int num){
        int val = 10;
        int length = 1;

        while(val <= num){
            val = val * 10;
            length ++;
        }
        return length;
    }

    public static StringBuilder convertThousand(int num){
        String[] unit = {"十","百","千"};
        String[] arr = {"零","一","二","三","四","五","六","七","八","九"};
        if(num == 0){
            return new StringBuilder(arr[0]);
        }

        int length = length(num);
        int scale = 10;
        int tmp = num;

        StringBuilder stringBuilder = new StringBuilder();
        // 中间多个零 和 末数零的处理
        boolean haveZero = false;
        for (int i = 0; i < length; i++) {
            int val = tmp % scale;
            tmp = tmp / scale;
            if(val == 0){
                haveZero = true;
                continue;
            }else if(haveZero && stringBuilder.length() > 0){
                stringBuilder.insert(0,arr[0]);
            }
            if(i > 0){
                stringBuilder.insert(0,unit[i-1]);
            }
            stringBuilder.insert(0,arr[val]);
            haveZero = false;
        }
        return stringBuilder;
    }

    // todo : 实现
    public static String convert(int num){
        String[] unit = {"万","亿"};
        int length = length(num);
        int section = length / 4 + 1;
        int tmp = num;
        StringBuilder stringBuilder = new StringBuilder();
        boolean haveZero = false;
        for (int i = 0; i < section; i++) {
            int val = tmp % 10000;
            tmp = tmp / 10000;
            if(val == 0){
                haveZero = true;
                continue;
            }else if(haveZero && stringBuilder.length() > 0){
                stringBuilder.insert(0,"零");
            }
            if(i > 0){
                stringBuilder.insert(0,unit[(i-1)%2]);
            }
            stringBuilder.insert(0,convertThousand(val));
//            System.out.println(convertThousand(val));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {


        System.out.println(convert(0));
        System.out.println(convert(5713));
        System.out.println(convert(1760));
        System.out.println(convert(1000));
        System.out.println(convert(100));
        System.out.println(convert(10));
        System.out.println(convert(1010));
        System.out.println(convert(101));
        System.out.println(convert(1001));

        System.out.println("----------------------");

        System.out.println(convert(12340));
        System.out.println(convert(1115713));
        System.out.println(convert(221760));
        System.out.println(convert(3010000));
        // todo : bug 四千零一万一十一
        System.out.println(convert(40010011));
        System.out.println(convert(100000));
        System.out.println(convert(101000));
        System.out.println(convert(101000));
        System.out.println(convert(100100));


    }
}
