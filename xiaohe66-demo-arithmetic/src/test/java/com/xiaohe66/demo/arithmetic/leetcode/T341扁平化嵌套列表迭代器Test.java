package com.xiaohe66.demo.arithmetic.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T341扁平化嵌套列表迭代器Test {


    class MyNestedInteger implements T341扁平化嵌套列表迭代器.NestedInteger {

        private Integer val;
        private List<T341扁平化嵌套列表迭代器.NestedInteger> list;

        public MyNestedInteger(Integer val) {
            this.val = val;
        }

        public MyNestedInteger(List<T341扁平化嵌套列表迭代器.NestedInteger> list) {
            this.list = list;
        }

        @Override
        public boolean isInteger() {
            return val != null;
        }

        @Override
        public Integer getInteger() {
            return val;
        }

        @Override
        public List<T341扁平化嵌套列表迭代器.NestedInteger> getList() {
            return list;
        }
    }

    @Test
    public void test1() {

        List<T341扁平化嵌套列表迭代器.NestedInteger> list = new ArrayList<>();

        list.add(new MyNestedInteger(1));
        //list.add(new MyNestedInteger(2));
        //list.add(new MyNestedInteger(3));
        //list.add(new MyNestedInteger(4));

        out(list);

        List<T341扁平化嵌套列表迭代器.NestedInteger> list1 = new ArrayList<>();

        list1.add(new MyNestedInteger(-1));
        list1.add(new MyNestedInteger(list));

        out(list1);

        List<T341扁平化嵌套列表迭代器.NestedInteger> list2 = new ArrayList<>();

        list2.add(new MyNestedInteger(-2));
        list2.add(new MyNestedInteger(list1));

        out(list2);

    }

    @Test
    public void test2() {

        List<T341扁平化嵌套列表迭代器.NestedInteger> list = new ArrayList<>();

        list.add(new MyNestedInteger(new ArrayList<>()));

        out(list);

    }

    @Test
    public void test3() {

        List<T341扁平化嵌套列表迭代器.NestedInteger> list = new ArrayList<>();

        list.add(new MyNestedInteger(new ArrayList<>()));


        List<T341扁平化嵌套列表迭代器.NestedInteger> list2 = new ArrayList<>();
        list2.add(new MyNestedInteger(2));

        list.add(new MyNestedInteger(new ArrayList<>()));
        list.add(new MyNestedInteger(list2));

        out(list);

    }

    public void out(List<T341扁平化嵌套列表迭代器.NestedInteger> list){

        T341扁平化嵌套列表迭代器.NestedIterator demo = new T341扁平化嵌套列表迭代器.NestedIterator(list);

        while (demo.hasNext()) {
            System.out.print(demo.next());
            System.out.print(',');
        }
        System.out.println();
    }

}