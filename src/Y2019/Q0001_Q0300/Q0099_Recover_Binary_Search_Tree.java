package Y2019.Q0001_Q0300;

public class Q0099_Recover_Binary_Search_Tree {

    TreeNode x = null;
    TreeNode y = null;
    TreeNode p = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int t = x.val;
        x.val = y.val;
        y.val = t;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);

        if (p != null && root.val < p.val) {
            y = root;
            if (x == null) x = p;
            else return;
        }
        p = root;

        dfs(root.right);
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
