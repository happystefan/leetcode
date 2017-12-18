package Q200_Q299;

import java.util.Stack;

/**
 * Created by mingqiangliang on 12/18/17.
 */
public class Q255_Verify_Preorder_Sequence_in_Binary_Search_Tree {

    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int i : preorder) {
            if (i < min) return false;
            while (!stack.isEmpty() && i > stack.peek()) {
                min = stack.pop();
            }
            stack.push(i);
        }
        return true;
    }

}
