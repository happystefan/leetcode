package Y2020.facebook.tree;

public class Q0099_Recover_Binary_Search_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode prev = null;
    TreeNode l = null;
    TreeNode r = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int t = l.val;
        l.val = r.val;
        r.val = t;
        return;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);

        if (prev != null && prev.val > root.val) {
            if (l == null) l = prev;
            r = root;
        }
        prev = root;

        dfs(root.right);
    }

}
