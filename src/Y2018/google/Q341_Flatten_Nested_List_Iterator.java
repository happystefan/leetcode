package Y2018.google;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Q341_Flatten_Nested_List_Iterator {


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
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


    public class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            Collections.reverse(nestedList);
            for (NestedInteger ni : nestedList) {
                stack.push(ni);
            }
        }

        @Override
        public Integer next() {
            return hasNext() ? stack.pop().getInteger() : null;
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                if (stack.peek().isInteger()) return true;
                List<NestedInteger> nestedList = stack.pop().getList();
                Collections.reverse(nestedList);
                for (NestedInteger ni : nestedList) {
                    stack.push(ni);
                }
            }
            return false;
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
