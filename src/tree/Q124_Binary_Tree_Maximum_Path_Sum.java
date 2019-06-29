package tree;

public class Q124_Binary_Tree_Maximum_Path_Sum {

    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        dfs(result, root);
        return result[0];
    }

    private int dfs(int[] result, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(0, dfs(result, root.left));
        int r = Math.max(0, dfs(result, root.right));
        result[0] = Math.max(result[0], l + r + root.val);
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
