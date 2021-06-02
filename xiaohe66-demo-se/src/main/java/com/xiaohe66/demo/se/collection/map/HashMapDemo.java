package com.xiaohe66.demo.se.collection.map;

import java.util.HashMap;

/**
 * HashMap
 * 1.不能用重复键
 * 2.可以有重复值
 * 3.无序
 *
 * @author xh
 * @date 17-12-27 027
 */
public class HashMapDemo {
    /**
     * hashMap的遍历
     * @param hashMap hashMap
     */
    static void print(HashMap<String,String> hashMap){
        //HashMap的遍历
        for (String key : hashMap.keySet()) {
            //遍历key获取value
            String val = hashMap.get(key);
            System.out.print(val+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<String,String>();
        //使用put加入元素
        hashMap.put("1","张三");
        hashMap.put("2","李四");
        hashMap.put("3","王五");

        print(hashMap);


        //HashMap不能有重复键，当给重复键赋值时，会替换原有值
        hashMap.put("2","李四2");
        hashMap.put("3","王五2");

        print(hashMap);

        //移出hashMap的值
        hashMap.remove("1");

        print(hashMap);

        //是否存在key
        System.out.println(hashMap.containsKey("2"));
        System.out.println(hashMap.containsKey("4"));

        //是否存在value
        System.out.println(hashMap.containsValue("李四2"));
        System.out.println(hashMap.containsValue("李四"));

    }
}
