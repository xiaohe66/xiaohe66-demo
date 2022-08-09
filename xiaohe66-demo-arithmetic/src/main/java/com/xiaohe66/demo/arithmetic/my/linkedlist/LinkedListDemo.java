package com.xiaohe66.demo.arithmetic.my.linkedlist;

/**
 * 链表
 *
 * @author xiaohe
 * @date 2019.03.17 16:36
 */
public class LinkedListDemo {

    /**
     * 创建链表，头插法
     *
     * @return 返回头指针
     */
    Node init1(char[] arr){
        int i = 0;
        Node first = new Node();
        Node node;
        while(i < arr.length){

            // 创建新节点
            node = new Node();
            node.data = arr[i++];

            // 1.使新创建的节点指向 链表的开头
            node.next = first.next;

            // 2.改变头指针的指向， 使其指向新的节点
            first.next = node;
        }

        return first;
    }

    /**
     * 创建链表，尾插法
     *
     * @return 返回头指针
     */
    Node init2(char[] arr){
        int i = 0;

        // 头指针
        Node first = new Node();

        // 尾指针，指向链表的最后一个元素
        Node last = first;

        // 中间节点，临时变量
        Node node;
        while (i < arr.length){

            // 创建新节点，并赋值
            node = new Node();
            node.data = arr[i++];

            // 1.在链表尾部插入新元素
            last.next = node;

            // 2.改变 last 的指向，使其指向最后一个元素
            last = node;
        }
        return first;
    }

    void out(Node node){
        if(node != null){
            while(node.next != null){
                node = node.next;
                System.out.print(node.data);
            }
            System.out.println();
        }
    }

    int size(Node node){
        Node tmp = node;
        int sum = 0;
        while (tmp.next != null){
            sum++;
            tmp = tmp.next;
        }
        return sum;
    }

    public static void main(String[] args) {

        char[] arr = "test linked list string".toCharArray();

        LinkedListDemo demo = new LinkedListDemo();

        Node node1 = demo.init1(arr);
        Node node2 = demo.init2(arr);

        demo.out(node1);
        demo.out(node2);

        System.out.println(demo.size(node1));
        System.out.println(demo.size(node2));

    }

}
