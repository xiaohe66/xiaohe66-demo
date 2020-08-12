package com.xiaohe66.demo.arithmetic.leetcode;

import com.xiaohe66.demo.arithmetic.leetcode.T133克隆图.Node;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class T133克隆图Test {

    T133克隆图 demo = new T133克隆图();

    @Test
    public void test1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node ret = demo.cloneGraph(node1);
        assertTrue(equals(node1, ret));
    }

    @Test
    public void test2() {
        Node node1 = new Node(1);

        Node ret = demo.cloneGraph(node1);
        assertTrue(equals(node1, ret));
    }

    @Test
    public void testEquals() {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node node12 = new Node(1);
        Node node22 = new Node(2);
        Node node32 = new Node(3);
        Node node42 = new Node(4);

        node12.neighbors.add(node22);
        node12.neighbors.add(node42);

        node22.neighbors.add(node12);
        node22.neighbors.add(node32);

        node32.neighbors.add(node22);
        node32.neighbors.add(node42);

        node42.neighbors.add(node12);
        node42.neighbors.add(node32);

        assertTrue(equals(node1, node12));
        assertFalse(equals(node1, node1));

        node12.neighbors.set(0, node2);
        assertFalse(equals(node1, node12));
    }

    @Test
    public void testEquals2() {

        Node node1 = new Node(1);
        Node node2 = new Node(1);

        assertTrue(equals(node1, node2));

        Node tmp = new Node(2);
        node2.neighbors.add(tmp);
        assertFalse(equals(node1, node2));

        node1.neighbors.add(tmp);
        assertFalse(equals(node1, node2));

        node1.neighbors.set(0,new Node(2));
        assertTrue(equals(node1, node2));

    }

    private boolean equals(Node obj1, Node obj2) {

        Set<Integer> mark = new HashSet<>();
        return equals(mark, obj1, obj2);
    }

    private boolean equals(Set<Integer> mark, Node obj1, Node obj2) {
        if (obj1 == obj2) {
            return false;
        }

        if (obj1.neighbors == null) {
            return obj2.neighbors == null;
        }

        if (obj1.val != obj2.val) {
            return false;
        }

        if (obj1.neighbors == obj2.neighbors) {
            return false;
        }

        if (obj1.neighbors.size() != obj2.neighbors.size()) {
            return false;
        }

        if (mark.contains(obj1.val)) {
            return true;
        }

        mark.add(obj1.val);

        int size = obj1.neighbors.size();
        for (int i = 0; i < size; i++) {
            Node node1 = obj1.neighbors.get(i);
            Node node2 = obj2.neighbors.get(i);
            if (!equals(mark, node1, node2)) {
                return false;
            }
        }

        return true;
    }

}