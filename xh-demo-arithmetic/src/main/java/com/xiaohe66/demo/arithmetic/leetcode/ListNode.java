package com.xiaohe66.demo.arithmetic.leetcode;

/**
 * @author xiaohe
 * @time 2020.10.13 14:00
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int... vals) {

        val = vals[0];
        ListNode node = this;
        for (int i = 1; i < vals.length; i++) {
            node.next = new ListNode(vals[i]);
            node = node.next;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode listNode = (ListNode) o;

        if (val != listNode.val) return false;
        return next != null ? next.equals(listNode.next) : listNode.next == null;
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        ListNode cur = this;

        while (cur != null) {
            if (cur != this) {
                stringBuilder.append(',');
            }
            stringBuilder.append(cur.val);
            cur = cur.next;
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
