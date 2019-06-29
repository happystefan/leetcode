package Y2018.linkedin;

import java.util.List;

public class Q339_Nested_List_Weight_Sum {

    public int depthSum(List<NestedInteger> nestedList) {
        int result = 0;
        for (NestedInteger list : nestedList) {
            result += sum(list, 1);
        }
        return result;
    }

    private int sum(NestedInteger ni, int depth) {
        if (ni.isInteger()) {
            return ni.getInteger() * depth;
        }
        int result = 0;
        for (NestedInteger i : ni.getList()) {
            result += sum(i, depth + 1);
        }
        return result;
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // Constructor initializes an empty nested list.
        // public NestedInteger();

        // Constructor initializes a single integer.
        // public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
