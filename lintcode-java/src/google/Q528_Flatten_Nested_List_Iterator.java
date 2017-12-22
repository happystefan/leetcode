package google;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q528_Flatten_Nested_List_Iterator {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> stack = new Stack<>();

        public void pushToStack(List<NestedInteger> nestedList) {
            Stack<NestedInteger> tstack = new Stack<>();
            for(NestedInteger ni : nestedList) tstack.push(ni);
            while (!tstack.isEmpty()) stack.push(tstack.pop());
        }

        public NestedIterator(List<NestedInteger> nestedList) {
            // Initialize your data structure here.
            pushToStack(nestedList);
        }

        // @return {int} the next element in the iteration
        @Override
        public Integer next() {
            // Write your code here
            return hasNext() ? stack.pop().getInteger() : null;

        }

        // @return {boolean} true if the iteration has more element or false
        @Override
        public boolean hasNext() {
            // Write your code here
            while (!stack.isEmpty() && !stack.peek().isInteger()) pushToStack(stack.pop().getList());
            return !stack.isEmpty();
        }

        @Override
        public void remove() {}
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */

}
