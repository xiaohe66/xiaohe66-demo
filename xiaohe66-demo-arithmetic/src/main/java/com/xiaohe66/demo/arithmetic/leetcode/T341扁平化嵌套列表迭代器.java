package com.xiaohe66.demo.arithmetic.leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author xiaohe
 * @time 2021.03.23 10:19
 */
public class T341扁平化嵌套列表迭代器 {

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了91.05%的用户
     * 内存消耗：41.1 MB, 在所有 Java 提交中击败了8.89%的用户
     */
    public static class NestedIterator implements Iterator<Integer> {

        private Stack<Iterator<NestedInteger>> stack = new Stack<>();

        private Boolean hasNext;

        private NestedInteger next;

        public NestedIterator(List<NestedInteger> nestedList) {
            if (nestedList.isEmpty()) {
                hasNext = false;
            } else {
                stack.push(nestedList.iterator());
            }
        }

        @Override
        public Integer next() {
            if (hasNext != null && hasNext) {
                Integer ret = next.getInteger();
                hasNext = null;
                return ret;
            }

            throw new NoSuchElementException();
        }

        @Override
        public boolean hasNext() {
            if (hasNext != null) {
                return hasNext;
            }

            if (stack.isEmpty()) {
                hasNext = false;
                return false;
            }

            Iterator<NestedInteger> iterator = stack.peek();

            if (iterator.hasNext()) {
                NestedInteger cur = iterator.next();

                if (cur.isInteger()) {

                    hasNext = true;
                    next = cur;
                    return true;

                }

                List<NestedInteger> list = cur.getList();

                if (!list.isEmpty()) {
                    stack.push(list.iterator());
                }
            } else {
                stack.pop();
            }


            return hasNext();
        }
    }

    public interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

}
