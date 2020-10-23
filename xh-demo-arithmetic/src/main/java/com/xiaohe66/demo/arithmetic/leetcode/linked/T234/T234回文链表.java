package com.xiaohe66.demo.arithmetic.leetcode.linked.T234;

import com.xiaohe66.demo.arithmetic.leetcode.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author xiaohe
 * @time 2020.10.23 11:13
 */
public class T234回文链表 {


    /**
     * 没看教程自己写的：
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.86%的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了96.89%的用户
     */
    public boolean isPalindrome(ListNode head) {


        /*
         * 主要思路：
         * 在遍历链表时，将链表分成2边。用last指向左边的最后一个，head指向右边的第1个。
         * 当遍历完全部链接后，若last链表和head链表是对称关系，则满足回文链表条件。
         * 这里有一个注意点，那便是链表的长度可能是单数，这就需要特殊处理了。
         */

        if (head == null || head.next == null) {
            return true;
        }

        int index = 1;
        ListNode last = null;
        ListNode curNode = head.next;
        ListNode tmp;

        while (curNode != null) {

            if (++index % 2 == 0) {
                tmp = head.next;

                head.next = last;
                last = head;

                head = tmp;
            }

            curNode = curNode.next;
        }

        if (index % 2 == 1) {
            head = head.next;
        }

        while (last != null) {
            if (last.val != head.val) {
                return false;
            }
            last = last.next;
            head = head.next;
        }

        return true;

    }


}
