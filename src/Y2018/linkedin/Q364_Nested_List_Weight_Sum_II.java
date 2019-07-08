package Y2018.linkedin;

import java.util.List;

public class Q364_Nested_List_Weight_Sum_II {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int[] maxDepth = new int[1];
        for (NestedInteger ni : nestedList) {
            dfs(maxDepth, ni, 1);
        }
        int result = 0;
        for (NestedInteger ni : nestedList) {
            result += sum(ni, maxDepth[0]);
        }
        return result;
    }

    private int sum(NestedInteger ni, int depth) {
        if (ni.isInteger()) {
            return ni.getInteger() * depth;
        }
        int result = 0;
        for (NestedInteger i : ni.getList()) {
            result += sum(i, depth - 1);
        }
        return result;
    }

    private void dfs(int[] maxDepth, NestedInteger ni, int curDepth) {
        maxDepth[0] = Math.max(maxDepth[0], curDepth);
        if (ni.isInteger()) {
            return;
        }
        for (NestedInteger i : ni.getList()) {
            dfs(maxDepth, i, curDepth + 1);
        }
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // Constructor initializes an empty nested list.
        // public NestedInteger();

        // Constructor initializes a single integer.
        // public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

}
