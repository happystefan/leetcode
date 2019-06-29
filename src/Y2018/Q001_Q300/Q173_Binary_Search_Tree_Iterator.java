package Y2018.Q001_Q300;

import java.util.Stack;

public class Q173_Binary_Search_Tree_Iterator {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class BSTIterator {

        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            push(root);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode cur = stack.pop();
            push(cur.right);
            return cur.val;
        }

        private void push(TreeNode root) {
            while (root.left != null) {
                push(root.left);
                root = root.left;
            }
        }
    }

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
