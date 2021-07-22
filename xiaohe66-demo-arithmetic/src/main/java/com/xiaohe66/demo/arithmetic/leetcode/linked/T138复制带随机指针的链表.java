package com.xiaohe66.demo.arithmetic.leetcode.linked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 1000
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 通过次数92,487提交次数143,936
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaohe
 * @time 2021.07.22 15:32
 */
public class T138复制带随机指针的链表 {


    Map<Node, Node> cachedNode = new HashMap<>();

    /**
     * 官方题解的思路，自己写的代码
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了82.07%的用户
     */
    public Node copyRandomList(Node head) {

        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }

        cur = head;
        while (cur != null) {

            Node random = cur.random;
            if (random != null) {
                cur.next.random = random.next;
            }

            cur = cur.next.next;
        }

        Node ans = new Node(0);
        Node ansCur = ans;

        cur = head;

        while (cur != null) {
            ansCur.next = cur.next;
            ansCur = ansCur.next;

            cur.next = ansCur.next;
            cur = cur.next;
        }

        return ans.next;
    }

    /**
     * 官方题解
     * 对比我自己写的，代码不知简单了多少！
     */
    public Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList3(head.next);
            headNew.random = copyRandomList3(head.random);
        }
        return cachedNode.get(head);
    }


    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了13.89%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了19.03%的用户
     */
    public Node copyRandomList2(Node head) {

        if (head == null) {
            return null;
        }

        Node ans = new Node(0);
        Node cur = ans;

        Map<Node, Node> map = new HashMap<>();

        while (head != null) {

            Node newNode = map.computeIfAbsent(head, k -> new Node(k.val));
            cur.next = newNode;

            cur = cur.next;

            if (head.random != null) {
                newNode = map.computeIfAbsent(head.random, k -> new Node(k.val));
                cur.random = newNode;
            }

            head = head.next;
        }

        return ans.next;
    }

    public static class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {

            Node cur = this;

            List<Node> list = new ArrayList<>();

            while (cur != null) {
                list.add(cur);
                cur = cur.next;
            }

            StringBuilder stringBuilder = new StringBuilder();

            cur = this;
            do {

                stringBuilder.append(",[");
                stringBuilder.append(cur.val);
                stringBuilder.append(',');

                stringBuilder.append(cur.random == null ?
                        null :
                        list.indexOf(cur.random));

                stringBuilder.append(']');
                cur = cur.next;

            } while (cur != null);

            stringBuilder.setCharAt(0, '[');
            stringBuilder.append(']');

            return stringBuilder.toString();
        }

    }

}
