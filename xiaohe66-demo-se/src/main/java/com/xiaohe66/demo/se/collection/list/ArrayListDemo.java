package com.xiaohe66.demo.se.collection.list;

import java.util.ArrayList;

/**
 * list接口的主要实现类之一
 *
 * 集合内的元素很少变化的推荐使用ArrayList
 *
 * 注意点：
 * 1.ArrayList是不同步的
 * 2.ArrayList的扩容非常消耗资源
 * 3.ArrayList低层是使用数组实现的
 *
 * @author xh
 * @date 17-12-24 024
 */
public class ArrayListDemo {

    private static void print(ArrayList<String> arrayList){
        System.out.print("集合内的数据：");
        for (String str : arrayList) {
            System.out.print(str+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        //使用add方法向信息中增加元素
        arrayList.add("张三");
        arrayList.add("李四");
        print(arrayList);


        arrayList.add("王五");
        print(arrayList);

        //使用set方法对集合中的某一个元素进行修改
        arrayList.set(0,"小何");
        print(arrayList);


        //使用remove删除一个元素中的值
        arrayList.remove(1);
        print(arrayList);



    }
}
