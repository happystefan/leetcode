package archive.tree;

import java.util.Stack;

public class Q783_Minimum_Distance_Between_BST_Nodes {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDiffInBST(TreeNode root) {
        int result = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                result = Math.min(result, curr.val-prev.val);
            }
            if (curr.right != null) {
                root = curr.right;
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }
            prev = curr;
        }
        return result;
    }

}
