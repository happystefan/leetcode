package Y2019.Q0001_Q0300;

public class Q0124_Binary_Tree_Maximum_Path_Sum {

    int maxsum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxsum;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = Math.max(0, dfs(root.left));
        int r = Math.max(0, dfs(root.right));
        maxsum = Math.max(maxsum, root.val + l + r);
        return Math.max(l, r) + root.val;
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
