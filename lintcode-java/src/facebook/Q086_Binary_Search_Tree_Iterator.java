package facebook;

import java.util.Stack;

public class Q086_Binary_Search_Tree_Iterator {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();

        /*
         * @param root: The root of binary tree.
         */
        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /*
         * @return: True if there has next node, or false
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /*
         * @return: return next node
         */
        public TreeNode next() {
            TreeNode result = stack.pop();
            TreeNode root = result.right;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            return result;
        }
    }

}
