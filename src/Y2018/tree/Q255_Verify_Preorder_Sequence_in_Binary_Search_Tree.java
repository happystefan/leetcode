package Y2018.tree;

import java.util.Stack;

public class Q255_Verify_Preorder_Sequence_in_Binary_Search_Tree {

    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        for (int val : preorder) {
            if (val < low) {
                return false;
            }
            while (!stack.isEmpty() && val > stack.peek()) {
                low = stack.pop();
            }
            stack.push(val);
        }
        return true;
    }

}
