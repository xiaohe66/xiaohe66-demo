package com.xiaohe66.demo.arithmetic.leetcode.tree;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * <p>
 * 请你实现 Trie 类：
 *
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *  
 * <p>
 * 示例：
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 *
 * <p>
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *  
 * <p>
 * 提示：
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 *
 * <p>
 * 通过次数87,240提交次数123,756
 *
 * @author xiaohe
 * @time 2021.04.14 11:23
 */
public class T208实现Trie_前缀树 {

    /**
     * 执行用时：42 ms, 在所有 Java 提交中击败了61.52%的用户
     * 内存消耗：46.6 MB, 在所有 Java 提交中击败了94.53%的用户
     */
    public static class Impl {

        Node root = new Node();

        public void insert(String word) {

            Node node = root;

            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.childNode == null) {
                    node.childNode = new Node[26];
                }
                if (node.childNode[index] == null) {
                    node.childNode[index] = new Node();
                }
                node = node.childNode[index];
            }

            node.isEnd = true;
        }

        public boolean search(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';

                if (node.childNode == null || node.childNode[index] == null) {
                    return false;
                }
                node = node.childNode[index];
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (node.childNode == null || node.childNode[index] == null) {
                    return false;
                }
                node = node.childNode[index];
            }
            return true;
        }

        private class Node {

            Node[] childNode;
            boolean isEnd;
        }
    }

    /**
     * 使用二叉搜索树：
     * 执行用时：43 ms, 在所有 Java 提交中击败了54.04%的用户
     * 内存消耗：46.4 MB, 在所有 Java 提交中击败了96.84%的用户
     */
    public static class Impl2 {

        Node root;

        public void insert(String word) {
            if (root == null) {
                root = new Node(word);
                return;
            }

            Node node = root;
            while (true) {
                int compareTo = node.val.compareTo(word);
                if (compareTo > 0) {
                    if (node.left == null) {
                        node.left = new Node(word);
                        break;
                    }
                    node = node.left;

                } else if (compareTo < 0) {

                    if (node.right == null) {
                        node.right = new Node(word);
                        break;
                    }
                    node = node.right;
                } else {
                    return;
                }
            }

        }

        public boolean search(String word) {
            Node node = root;
            while (node != null) {
                int compareTo = node.val.compareTo(word);
                if (compareTo == 0) {
                    return true;

                }
                node = compareTo > 0 ? node.left : node.right;
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            Node node = root;
            while (node != null) {
                int i = 0;
                while (i < prefix.length()) {
                    if (i >= node.val.length()) {
                        node = node.right;
                        break;
                    }
                    char p = prefix.charAt(i);
                    char c = node.val.charAt(i);
                    if (c < p) {
                        node = node.right;
                        break;

                    } else if (c > p) {
                        node = node.left;
                        break;
                    }
                    i++;
                }
                if (i == prefix.length()) {
                    return true;
                }
            }
            return false;
        }

        private class Node {

            String val;
            Node left;
            Node right;

            private Node(String val) {
                this.val = val;
            }
        }
    }


}

/**
 * 原题目的类结构
 */
class Trie {

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return false;
    }
}
