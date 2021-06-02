package com.xiaohe66.demo.arithmetic.leetcode.linked;

import com.xiaohe66.demo.arithmetic.leetcode.ListNode;

/**
 * 给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * <p>
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *  
 * <p>
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *  
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 *
 * <p>
 * 通过次数124,972提交次数234,205
 *
 * @author xiaohe
 * @time 2021.03.18 14:15
 */
public class T92反转链表2 {


    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了43.90%的用户
     * <p>
     * 根据题意，可得以下结论：
     * 1.若 right = 1,则 left 必然为1 ，则直接返回
     * 2.若 left = right，则说明不需要反转链表，直接返回
     * 3.若 left ！= 1，则说明头指针没变，最终结果必然是返回 初始的头指针
     * <p>
     * 思路：
     * 将链表拆分成3段，设计3个指针：  1段尾、2段头尾，3段头
     * 在遍历时，一直改变上面3个指针的指向直至结束
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (right == 1) {
            return head;
        }

        if (left == right) {
            return head;
        }

        ListNode tail1 = null;

        ListNode cur = head;

        for (int i = 1; i < left; i++) {
            tail1 = cur;
            cur = cur.next;
        }

        // 执行到这1步, tail1 指向的，是第1段的末尾（不包括 left）

        ListNode head2 = null;
        ListNode tail2 = cur;
        ListNode head3 = cur;


        for (int i = left; i <= right; i++) {

            head3 = head3.next;

            cur.next = head2;
            head2 = cur;

            cur = head3;
        }

        tail2.next = head3;
        if (left == 1) {
            return head2;
        } else {
            tail1.next = head2;
            return head;
        }

    }

}
