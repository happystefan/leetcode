package Y2020.facebook;

public class Q0938_Range_Sum_of_BST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        int[] rslt = new int[0];
        dfs(rslt, root, L, R);
        return rslt[0];
    }

    private void dfs(int[] rslt, TreeNode root, int L, int R) {
        if (root == null) return;
        if (root.val >= L && root.val <= R) rslt[0] += root.val;
        if (root.val > L) dfs(rslt, root.left, L, R);
        if (root.val < R) dfs(rslt, root.right, L, R);
    }

}
