package com.xiaohe66.demo.se.collection.list;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * list接口的主要实现类之一
 *
 * 集合内的元素有较多变动时推荐使用LinkedList
 *
 * 注意点：
 * 1.LinkedList的底层实现是链表
 *
 * @author xh
 * @date 17-12-24 024
 */
public class LinkedListDemo {

    static void print(LinkedList<String> linkedList){
        //使用迭代器输出list中的所有元素
        ListIterator<String> listIterator = linkedList.listIterator();
        while(listIterator.hasNext()){
            System.out.print(listIterator.next()+" ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("张三");
        linkedList.add("李四");
        linkedList.add("王五");
        print(linkedList);

        //获取第1个无素
        System.out.println(linkedList.getFirst());
        print(linkedList);

        //获取第1个元素，并从list中移除
        System.out.println(linkedList.pollFirst());
        print(linkedList);

        //获取指定元素在list中的索引
        System.out.println(linkedList.indexOf("王五"));
        print(linkedList);
    }
}
