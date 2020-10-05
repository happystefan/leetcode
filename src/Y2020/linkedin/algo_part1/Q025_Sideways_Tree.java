package Y2020.linkedin.algo_part1;

import java.util.Stack;

public class Q025_Sideways_Tree {

    class solution_rec {

        public TreeNode convert(TreeNode root) {
            if (root == null ||
                    root.left == null && root.right == null) {
                return root;
            }
            TreeNode rslt = convert(root.left);
            root.left.left = root.right;
            root.left.right = root;

            root.left = null;
            root.right = null;

            return rslt;
        }

    }

    class solution_stack {

        public TreeNode convert(TreeNode root) {
            if (root == null ||
                    root.left == null && root.right == null) {
                return root;
            }
            Stack<TreeNode> nodeStack = new Stack<>();
            Stack<TreeNode> leafStack = new Stack<>();
            TreeNode curr = root;
            while (curr != null) {
                nodeStack.add(curr);
                leafStack.add(curr.right);
                curr = curr.left;
            }
            TreeNode rslt = nodeStack.pop();
            leafStack.pop();
            curr = rslt;
            while (!nodeStack.isEmpty()) {
                curr.right = nodeStack.pop();
                curr.left = leafStack.pop();
                curr = curr.right;
            }
            curr.left = curr.right = null;
            return rslt;
        }

    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
