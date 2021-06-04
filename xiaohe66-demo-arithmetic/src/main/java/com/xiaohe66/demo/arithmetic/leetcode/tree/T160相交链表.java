package com.xiaohe66.demo.arithmetic.leetcode.tree;

import com.xiaohe66.demo.arithmetic.leetcode.ListNode;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 示例 2：
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <p>
 * 示例 3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 * <p>
 * 提示：
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 * <p>
 * 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
 * <p>
 * 通过次数253,384提交次数426,574
 *
 * @author xiaohe
 * @time 2021.06.04 13:46
 */
public class T160相交链表 {

    /**
     * 官方题解：
     *
     * <p>
     * 思路：双指针
     * 指针A，遍历链表A，到尾部null后，开始遍历链表B
     * 指针B，遍历链表B，到尾部null后，开始遍历链表A
     *
     * <p>
     * 存在相交节点：
     * 链表A离交点的距离为a，链表B离交点的距离为b。相交部分的长度为 len。
     * 则：
     * (指针A) a + len + b == b + len + a (指针B)
     *
     * <p>
     * 不存在相交节点：
     * 链表A的长度为a，链表B的长度为b
     * 则：
     * (指针A) a + b == b + a (指针B)
     *
     * <p>
     * 无论A和B的长度相同或不相同，都必然会出现 A==B
     * 若此时A != null，则说明存在相交节点，此时A和B指向的节点便是开始位置
     * 若此时A == null，则说明不存在相交节点，此时A和B都指向节点的尾部
     *
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.8 MB, 在所有 Java 提交中击败了96.14%的用户
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode node1 = headA;
        ListNode node2 = headB;

        for (; ; ) {
            if (node1 == node2) {
                return node1;
            }

            if (node1 == null) {
                node1 = headB;
            } else {
                node1 = node1.next;
            }

            if (node2 == null) {
                node2 = headA;
            } else {
                node2 = node2.next;
            }
        }
    }
}
