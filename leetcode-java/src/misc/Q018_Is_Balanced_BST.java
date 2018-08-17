package misc;

public class Q018_Is_Balanced_BST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalancedBST(TreeNode root) {
        return isBalanced(root) && isBST(root);
    }

    private boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left)-depth(root.right)) <= 1 && isBalancedBST(root.left) && isBalancedBST(root.right);
    }

    private int depth(TreeNode root) {
        return root == null ? 0 : 1+Math.max(depth(root.left), depth(root.right));
    }

    private boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (root.left == null || root.left.val < root.val && isBST(root.left)) &&
                (root.right==null || root.right.val> root.val && isBST(root.right));
    }

}
