package com.xiaohe66.demo.arithmetic.leetcode.linked;

import org.junit.Test;

public class T138复制带随机指针的链表Test {

    private T138复制带随机指针的链表 demo = new T138复制带随机指针的链表();

    @Test
    public void test1() {


        T138复制带随机指针的链表.Node node5 = new T138复制带随机指针的链表.Node(1);
        T138复制带随机指针的链表.Node node4 = new T138复制带随机指针的链表.Node(10, node5);
        T138复制带随机指针的链表.Node node3 = new T138复制带随机指针的链表.Node(11, node4);
        T138复制带随机指针的链表.Node node2 = new T138复制带随机指针的链表.Node(13, node3);
        T138复制带随机指针的链表.Node node1 = new T138复制带随机指针的链表.Node(7, node2);

        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        System.out.println(node1);

        T138复制带随机指针的链表.Node node = demo.copyRandomList(node1);

        System.out.println(node);

    }


}