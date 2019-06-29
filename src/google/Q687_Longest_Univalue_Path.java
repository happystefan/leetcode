package google;

public class Q687_Longest_Univalue_Path {

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int[] ans = new int[1];
        dfs(root, ans);
        return ans[0];
    }

    private int dfs(TreeNode root, int[] ans) {
        int l = root.left == null ? 0 : dfs(root.left, ans);
        int r = root.right == null ? 0 : dfs(root.right, ans);
        int ll = root.left != null && root.val == root.left.val ? l + 1 : 0;
        int rr = root.right != null && root.val == root.right.val ? r + 1 : 0;
        ans[0] = Math.max(ans[0], ll + rr);
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
