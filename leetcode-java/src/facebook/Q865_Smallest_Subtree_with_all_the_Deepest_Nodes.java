package facebook;

public class Q865_Smallest_Subtree_with_all_the_Deepest_Nodes {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode leftMost = null;
    TreeNode rightMost= null;
    int depth = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return lca(root, leftMost, rightMost);
    }

    private void dfs(TreeNode root, int d) {
        if (root == null) return;
        if (d > depth) {
            depth = d;
            leftMost = root;
            rightMost = null;
        } else if (d == depth) {
            rightMost = root;
        }
        dfs(root.left, d+1);
        dfs(root.right,d+1);
    }

    private TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) return null;
        if (root == a || root == b) return root;
        TreeNode l = lca(root.left, a, b);
        TreeNode r = lca(root.right,a, b);
        if (l != null && r != null) return root;
        else if (l != null) return l;
        else if (r != null) return r;
        return null;
    }

}

