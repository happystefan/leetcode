package Y2019.misc;

public class Q0004_Remove_An_Edge_To_Recover_Binary_Search_Tree {

    public void removeAnEdgeToRecoverBinarySearchTree(TreeNode root) {
        dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private void dfs(TreeNode root, long min, long max) {
        if (root == null) return;
        if (root.left != null) {
            if (root.left.val <= min || root.right.val >= max) {
                root.left = null;
                return;
            }
            dfs(root.left, min, root.val);
        }
        if (root.right != null) {
            if (root.right.val <= min || root.right.val >= max) {
                root.right = null;
                return;
            }
            dfs(root.right, root.val, max);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

}
