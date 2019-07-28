package Y2019.Q0001_Q0300;

import java.util.Stack;

public class Q0114_Flatten_Binary_Tree_to_Linked_List {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: recursive
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        public void flatten(TreeNode root) {
            if (root == null) return;
            TreeNode l = root.left;
            TreeNode r = root.right;
            flatten(l);
            flatten(r);
            root.left = null;
            root.right = l;
            while (root.right != null) root = root.right;
            root.right = r;
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: recursive
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {

        TreeNode prev = null;

        public void flatten(TreeNode root) {
            if (root == null) return;
            flatten(root.right);
            flatten(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 3: iterative
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution3 {

        public void flatten(TreeNode root) {
            while (root != null) {
                if (root.left != null) {
                    TreeNode curr = root.left;
                    while (curr.right != null) curr = curr.right;
                    curr.right = root.right;
                    root.right = root.left;
                    root.left = null;
                }
                root = root.right;
            }
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 4: stack
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution4 {

        public void flatten(TreeNode root) {
            if (root == null) return;
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.right != null) stack.add(node.right);
                if (node.left != null) stack.add(node.left);
                node.left = null;
                if (!stack.isEmpty()) node.right = stack.peek();
            }
        }

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
