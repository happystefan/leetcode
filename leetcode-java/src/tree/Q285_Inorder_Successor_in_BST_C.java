package tree;

public class Q285_Inorder_Successor_in_BST_C {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            return finMin(p.right);
        }
        return inorderSuccessor(root, p, null);
    }

    private TreeNode inorderSuccessor(TreeNode root, TreeNode p, TreeNode succ) {
        if (root == null || p == null || root.val == p.val) {
            return succ;
        }
        if (root.val > p.val) {
            return inorderSuccessor(root.left, p, root);
        }
        return inorderSuccessor(root.right, p, succ);
    }

    private TreeNode finMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
