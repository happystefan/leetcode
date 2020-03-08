package Y2020.facebook;

public class Q0129_Sum_Root_to_Leaf_Numbers {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int[] rslt = new int[]{0};
        dfs(root, 0, rslt);
        return rslt[0];
    }

    private void dfs(TreeNode root, int val, int[] rslt) {
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            rslt[0] += val;
            return;
        }
        if (root.left != null) dfs(root.left, val, rslt);
        if (root.right != null) dfs(root.right, val, rslt);
    }

}
