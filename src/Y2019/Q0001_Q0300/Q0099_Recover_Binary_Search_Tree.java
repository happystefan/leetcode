package Y2019.Q0001_Q0300;

public class Q0099_Recover_Binary_Search_Tree {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: dfs
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    TreeNode x = null;
    TreeNode y = null;
    TreeNode p = null;

    public void recoverTree_dfs(TreeNode root) {
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

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: morris traversal
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public void recoverTree(TreeNode root) {
        TreeNode x = null;
        TreeNode y = null;
        TreeNode p = null;
        TreeNode pred = null;
        while (root != null) {
            if (root.left == null) {
                {
                    if (p != null && p.val > root.val) {
                        y = root;
                        if (x == null) x = p;
                    }
                    p = root;
                }
                root = root.right;
            } else {
                pred = root.left;
                while (pred.right != null && pred.right != root) pred = pred.right;
                if (pred.right == null) {
                    pred.right = root;
                    root = root.left;
                } else {
                    {
                        if (p != null && p.val > root.val) {
                            y = root;
                            if (x == null) x = p;
                        }
                        p = root;
                    }
                    pred.right = null;
                    root = root.right;
                }
            }
        }
        int t = x.val;
        x.val = y.val;
        y.val = t;
    }

}
