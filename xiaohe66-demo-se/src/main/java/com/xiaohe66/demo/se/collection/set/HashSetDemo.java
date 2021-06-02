package com.xiaohe66.demo.se.collection.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet
 * 1.无序
 * 2.不允许重复
 *
 * @author xh
 * @date 17-12-26 026
 */
public class HashSetDemo {



    static void print(HashSet<String> hashSet){
        //使用迭代器输出list中的所有元素
        Iterator<String> listIterator = hashSet.iterator();
        while(listIterator.hasNext()){
            System.out.print(listIterator.next()+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("张三");
        hashSet.add("李四");
        hashSet.add("王五");

        print(hashSet);

        //不会有重复值
        hashSet.add("何少");
        hashSet.add("何少");
        hashSet.add("何少");
        hashSet.add("何少");

        print(hashSet);
    }
}
