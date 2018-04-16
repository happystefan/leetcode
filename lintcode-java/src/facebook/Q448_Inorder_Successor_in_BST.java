package facebook;

public class Q448_Inorder_Successor_in_BST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode result = null;
        while (root != null) {
            if (p.val < root.val) {
                result = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return result;
    }

}
