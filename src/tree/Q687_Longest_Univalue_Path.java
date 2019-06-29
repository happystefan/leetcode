package tree;

public class Q687_Longest_Univalue_Path {

    public int longestUnivaluePath(TreeNode root) {
        int[] result = new int[1];
        dfs(result, root);
        return result[0];
    }

    private int dfs(int[] result, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(result, root.left);
        int r = dfs(result, root.right);
        int ll = root.left != null && root.val == root.left.val ? l + 1 : 0;
        int rr = root.right != null && root.val == root.right.val ? r + 1 : 0;
        result[0] = Math.max(result[0], ll + rr);
        return Math.max(ll, rr);
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
