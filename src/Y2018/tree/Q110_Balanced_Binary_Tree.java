package Y2018.tree;

public class Q110_Balanced_Binary_Tree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        return Math.abs(l - r) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
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
