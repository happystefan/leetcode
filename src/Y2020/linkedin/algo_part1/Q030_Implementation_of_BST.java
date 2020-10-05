package Y2020.linkedin.algo_part1;

import java.util.Stack;

public class Q030_Implementation_of_BST {

    class BST {

        private TreeNode root = null;

        public void insert(int val) {
           root = insert(this.root, null, val);
        }

        private TreeNode insert(TreeNode root, TreeNode parent, int val) {
            if (root == null) {
                TreeNode node = new TreeNode(val);
                node.parent = parent;
                return node;
            }
            if (val < root.val) {
                root.left = insert(root.left, root, val);
            } else {
                root.right = insert(root.right, root, val);
            }
            return root;
        }

        public TreeNode find(int val) {
            return find(this.root, val);
        }

        private TreeNode find(TreeNode root, int val) {
            if (root == null) return null;
            if (val == root.val) return root;
            return find(val < root.val ? root.left : root.right, val);
        }

        public void remove(int val) {
            this.root = remove(this.root, val);
        }

        private TreeNode remove(TreeNode root, int val) {
            if (root == null) return root;
            if (val < root.val) {
                root.left = remove(root.left, val);
            } else if (val > root.val) {
                root.right = remove(root.right, val);
            } else {
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                int min = findMin(root.right);
                root.val = min;
                root.right = remove(root.right, min);
            }
            return root;
        }

        private int findMin(TreeNode root) {
            while (root.left != null) {
                root = root.left;
            }
            return root.val;
        }

    }

    class Inorder_Iterator {

        Stack<TreeNode> stack = new Stack();

        public Inorder_Iterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

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

    class Preorder_Iterator {
        Stack<TreeNode> stack = new Stack();

        public Preorder_Iterator(TreeNode root) {
            if (root != null) {
                stack.push(root);
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            return node.val;
        }

    }


    class Postorder_Iterator {
        Stack<TreeNode> stack = new Stack();

        public Postorder_Iterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                if (root.left != null )  root = root.left;
                else root = root.right;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            TreeNode node = stack.pop();
            if (node.parent != null &&  node == node.parent.left) {
                TreeNode curr = node.right;
                while (curr != null) {
                    stack.push(curr);
                    if (curr.left != null) curr = curr.left;
                    else curr = curr.right;
                }
            }
            return node.val;
        }

        TreeNode prev = null;
        public int next_wo_parent() {
            TreeNode node = stack.peek();
            if (prev == node.right) {
                prev = node;
                return stack.pop().val;
            } else {
                TreeNode curr = node.right;
                while (curr != null) {
                    stack.push(curr);
                    if (curr.left != null) curr = curr.left;
                    else curr = curr.right;
                }
                prev = stack.pop();
                return prev.val;
            }
        }

    }


    class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}


