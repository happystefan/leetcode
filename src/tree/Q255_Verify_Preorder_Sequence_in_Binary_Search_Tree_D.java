package tree;

import java.util.Stack;

public class Q255_Verify_Preorder_Sequence_in_Binary_Search_Tree_D {

    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        int i = -1;
        for (int val : preorder) {
            if (val < low) {
                return false;
            }
            while (i >= 0 && val > preorder[i]) {
                low = preorder[i--];
            }
            preorder[++i] = val;
        }
        return true;
    }

}
