package google;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by mingqiangliang on 12/22/17.
 */
public class Q528_Flatten_Nested_List_Iterator_B {
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

        public NestedIterator(List<NestedInteger> nestedList) {
            // Initialize your data structure here.
            for (int i = nestedList.size()-1; i >= 0; i--) stack.push(nestedList.get(i));
        }

        // @return {int} the next element in the iteration
        @Override
        public Integer next() {
            // Write your code here
           return stack.pop().getInteger();

        }

        // @return {boolean} true if the iteration has more element or false
        @Override
        public boolean hasNext() {
            // Write your code here
            while (!stack.isEmpty()) {
                if (stack.peek().isInteger()) return true;
                List<NestedInteger> nestedList = stack.pop().getList();
                for (int i = nestedList.size()-1; i >= 0; i--) stack.push(nestedList.get(i));
            }
            return false;
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

