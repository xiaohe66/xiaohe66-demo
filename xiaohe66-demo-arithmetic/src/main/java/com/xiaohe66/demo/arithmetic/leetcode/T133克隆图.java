package com.xiaohe66.demo.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * <p>测试用例格式：
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 *
 * <p>
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 * <p>
 * 输入：adjList = [[]]
 * 输出：[[]]
 * 解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
 * <p>
 * 输入：adjList = []
 * 输出：[]
 * 解释：这个图是空的，它不含任何节点。
 * <p>
 * 提示：
 * 1.节点数不超过 100 。
 * 2.每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100。
 * 3.无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 4.由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 *
 * @author xiaohe
 * @time 2020.08.12 10:36
 */
public class T133克隆图 {

    Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> mark = new HashMap<>();

        return clone(mark, node);
    }

    /**
     * 思路:
     * 在遍历整个图时，会出现环，因此需要备份处理过的节点，这里使用Map来备份
     */
    private Node clone(Map<Integer, Node> mark, Node node) {
        if (node == null) {
            return null;
        }

        Node ret = mark.get(node.val);
        if (ret != null) {
            return ret;
        }

        if (node.neighbors == null) {
            ret = new Node(node.val, null);
            mark.put(node.val, ret);
        } else {
            ret = new Node(node.val);
            mark.put(node.val, ret);
            for (Node neighbor : node.neighbors) {
                ret.neighbors.add(clone(mark, neighbor));
            }
        }

        return ret;
    }

    static class Node {
        int val;
        List<Node> neighbors;

        Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }

    }

}

