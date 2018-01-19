package com.xiaohe66.demo.se.common;

import java.util.Arrays;
import java.util.List;

/**
 * 常用数组操作方法
 *
 * @author xh
 * @date 17-12-20 020
 */
public class ArraysDemo {

    public static void main(String[] args) {
        //输出数组内容
        System.out.println(Arrays.toString(new String[]{"篮球","足球","排球"}));
        //转换成List
        List<String> list = Arrays.asList("篮球","足球","排球");

        //排序
        int[] arr = new int[]{122,3423,457,121};
        System.out.println("排序前:"+Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("排序后:"+Arrays.toString(arr));

        //数组中查找
        System.out.println(Arrays.binarySearch(arr,457));
        System.out.println(Arrays.binarySearch(arr,957));

        //将数组中的值都设置为指定值
        Arrays.fill(arr,0);
        System.out.println(Arrays.toString(arr));
    }
}
