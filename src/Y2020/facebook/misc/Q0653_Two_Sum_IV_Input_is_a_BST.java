package Y2020.facebook.misc;

import java.util.Stack;

public class Q0653_Two_Sum_IV_Input_is_a_BST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> lstack = new Stack<>();
        Stack<TreeNode> rstack = new Stack<>();
        buildLStack(lstack, root);
        buildRStack(rstack, root);
        TreeNode l = nextL(lstack);
        TreeNode r = nextR(rstack);
        while (l != r) {
            int sum = l.val + r.val;
            if (sum < k) l = nextL(lstack);
            else if (sum > k) r = nextR(rstack);
            else return true;
        }
        return false;
    }

    private TreeNode nextL(Stack<TreeNode> stack) {
        TreeNode rslt = stack.pop();
        TreeNode curr = rslt.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return rslt;
    }

    private TreeNode nextR(Stack<TreeNode> stack) {
        TreeNode rslt = stack.pop();
        TreeNode curr = rslt.left;
        while (curr != null) {
            stack.push(curr);
            curr = curr.right;
        }
        return rslt;
    }

    private void buildLStack(Stack<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    private void buildRStack(Stack<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.right;
        }
    }

}
