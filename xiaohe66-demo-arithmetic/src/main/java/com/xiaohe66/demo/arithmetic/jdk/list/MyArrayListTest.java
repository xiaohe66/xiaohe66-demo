package com.xiaohe66.demo.arithmetic.jdk.list;

/**
 * @author xiaohe
 * @date 2019.04.12 17:53
 */
public class MyArrayListTest {

    static void test(MyArrayList<String> list){
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println("-----------------------");
        System.out.println(list.remove(0));
        System.out.println("-----------------------");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        try {
            System.out.println(list.get(2));
        } catch (Exception e) {
            System.out.println("出异常啦："+e.getMessage());
        }
    }

    public static void main(String[] args) {


        test(new MyArrayList<>());
        System.out.println("-----------------------");
        MyArrayList list = new MyArrayList<>(2);
        test(list);

        list.add("4");

        System.out.println("-----------------------");
        System.out.println(list.remove(1));

        System.out.println("-----------------------");
        System.out.println(list.get(1));

    }
}
