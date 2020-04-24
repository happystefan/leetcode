package Y2020.facebook.misc;

import java.util.*;

public class Q0341_Flatten_Nested_List_Iterator {

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return null if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    class solution_stack {

        public class NestedIterator implements Iterator<Integer> {

            Stack<NestedInteger> stack = new Stack<>();

            public NestedIterator(List<NestedInteger> nestedList) {
                Collections.reverse(nestedList);
                for (NestedInteger i : nestedList) stack.push(i);
            }

            @Override
            public Integer next() {
                return hasNext() ? stack.pop().getInteger() : null;
            }

            @Override
            public boolean hasNext() {
                while (!stack.isEmpty()) {
                    if (stack.peek().isInteger()) return true;
                    List<NestedInteger> list = stack.pop().getList();
                    Collections.reverse(list);
                    for (NestedInteger i : list) stack.add(i);
                }
                return false;
            }
        }

    }

    class solution_deque {

        public class NestedIterator implements Iterator<Integer> {

            Deque<NestedInteger> Q = new LinkedList<>();

            public NestedIterator(List<NestedInteger> nestedList) {
                Q.addAll(nestedList);
            }

            @Override
            public Integer next() {
                return hasNext() ? Q.pollFirst().getInteger() : null;
            }

            @Override
            public boolean hasNext() {
                while (!Q.isEmpty()) {
                    if (Q.peekFirst().isInteger()) return true;
                    List<NestedInteger> list = Q.pollFirst().getList();
                    list.addAll(Q);
                    Q = new LinkedList<>(list);
                }
                return false;
            }
        }

    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
