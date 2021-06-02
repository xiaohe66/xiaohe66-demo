package com.xiaohe66.demo.arithmetic.leetcode.linked;

import com.xiaohe66.demo.arithmetic.leetcode.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 * @author xiaohe
 * @time 2020.10.13 13:59
 */
public class T24两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {

        ListNode first = null;
        ListNode tmp;

        ListNode tail = null;

        while (head != null) {
            if (head.next != null) {
                tmp = head.next;
                head.next = tmp.next;
                tmp.next = head;

                if (tail != null) {
                    tail.next = tmp;
                }
                if (first == null) {
                    first = tmp;
                }

                tail = head;
                head = head.next;
            } else if (first == null) {

                return head;

            } else {
                break;
            }
        }

        return first;

    }

}
