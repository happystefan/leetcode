package Y2020.facebook;

public class Q0530_Minimum_Absolute_Difference_in_BST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        int[] rslt = new int[]{Integer.MAX_VALUE};
        dfs(root, rslt);
        return rslt[0];
    }

    private void dfs(TreeNode root, int[] rslt) {
        if (root == null) return;
        dfs(root.left, rslt);

        if (prev != null) rslt[0] = Math.min(rslt[0], Math.abs(root.val - prev));
        prev = root.val;

        dfs(root.right, rslt);
    }

}
