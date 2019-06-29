package Y2018.facebook;

import java.util.Stack;

public class Q173_Binary_Search_Tree_Iterator {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class BSTIterator {
        Stack<TreeNode> stack = new Stack();

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
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
            TreeNode top = stack.pop();
            TreeNode curr = top.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            return top.val;
        }
    }

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
