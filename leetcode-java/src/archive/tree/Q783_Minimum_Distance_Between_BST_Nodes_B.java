package archive.tree;

public class Q783_Minimum_Distance_Between_BST_Nodes_B {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int result = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev != null) {
            result = Math.min(result, root.val-prev.val);
        }
        prev = root;
        dfs(root.right);
    }

}
