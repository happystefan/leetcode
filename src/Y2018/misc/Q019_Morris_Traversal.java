package Y2018.misc;

import java.util.LinkedList;
import java.util.List;

public class Q019_Morris_Traversal {

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {

        /*
         *--------------------------------------------------------------------------------------------------------------
         *
         * in order traversal
         *
         *--------------------------------------------------------------------------------------------------------------
         */
        public List<Integer> inOrder(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            TreeNode curr = root;
            TreeNode prev;
            while (curr != null) {
                if (curr.left == null) {
                    result.add(curr.val);
                    curr = curr.right;
                } else {
                    prev = curr.left;
                    while (prev.right != null && prev.right != curr) prev = prev.right;
                    if (prev.right == null) {
                        prev.right = curr;
                        curr = curr.left;
                    } else {
                        result.add(curr.val);
                        prev.right = null;
                        curr = curr.right;
                    }
                }
            }
            return result;
        }

        /*
         *--------------------------------------------------------------------------------------------------------------
         *
         * pre order
         *
         *--------------------------------------------------------------------------------------------------------------
         */
        public List<Integer> preOrder(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            TreeNode curr = root;
            TreeNode prev;
            while (curr != null) {
                if (curr.left == null) {
                    result.add(curr.val);
                    curr = curr.right;
                } else {
                    prev = curr.left;
                    while (prev.right != null && prev.right != curr) prev = prev.right;
                    if (prev.right == null) {
                        result.add(curr.val);
                        prev.right = curr;
                        curr = curr.left;
                    } else {
                        prev.right = null;
                        curr = curr.right;
                    }
                }
            }
            return result;
        }

        /*
         *--------------------------------------------------------------------------------------------------------------
         *
         * post order traversal
         *
         *--------------------------------------------------------------------------------------------------------------
         */
        public List<Integer> postOrder(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            TreeNode dummy = new TreeNode(-1);
            dummy.left = root;
            TreeNode curr = dummy;
            TreeNode prev;
            while (curr != null) {
                if (curr.left == null) {
                    curr = curr.right;
                } else {
                    prev = curr.left;
                    while (prev.right != null && prev.right != curr) prev = prev.right;
                    if (prev.right == null) {
                        prev.right = curr;
                        curr = curr.left;
                    } else {
                        visit(result, curr.left, prev);
                        prev.right = null;
                        curr = curr.right;
                    }
                }
            }
            return result;
        }

        private void visit(List<Integer> result, TreeNode from, TreeNode to) {
            /*
             *----------------------------------------------------------------------------------------------------------
             *
             * version 1: insert value by index
             *
             *----------------------------------------------------------------------------------------------------------
             */
            {
                int i = 0;
                while (true) {
                    result.add(result.size() - i, from.val);
                    if (from.val == to.val) break;
                    from = from.right;
                    i++;
                }
            }
            /*
             *----------------------------------------------------------------------------------------------------------
             *
             * version 2: reverse, visit, then reverse back
             *
             *----------------------------------------------------------------------------------------------------------
             */
            {
                reverse(from, to);
                TreeNode curr = to;
                while (true) {
                    result.add(curr.val);
                    if (curr == from) break;
                    curr = curr.right;
                }
                reverse(to, from);
            }
        }

        private void reverse(TreeNode from, TreeNode to) {
            if (from == to) return;
            TreeNode head = from, next = from.right;
            while (true) {
                TreeNode tmp = next.right;
                next.right = head;
                head = next;
                next = tmp;
                if (head == to) break;
            }
        }

    }
}
