package Y2018.tree;

public class Q450_Delete_Node_in_a_BST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root = delete(root);
        }
        return root;
    }

    private TreeNode delete(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode parent = root;
        TreeNode succ = root.right;
        while (succ.left != null) {
            parent = succ;
            succ = succ.left;
        }
        if (succ == parent.right) {
            parent.right = succ.right;
        } else {
            parent.left = succ.right;
        }
        succ.left = root.left;
        succ.right = root.right;
        return succ;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
