package Y2020.facebook;

public class Q0124_Binary_Tree_Maximum_Path_Sum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] rslt = new int[]{Integer.MIN_VALUE};
        dfs(root, rslt);
        return rslt[0];
    }

    private int dfs(TreeNode root, int[] rslt) {
        if (root == null) return 0;
        int l = Math.max(0, dfs(root.left, rslt));
        int r = Math.max(0, dfs(root.right, rslt));
        rslt[0] = Math.max(rslt[0], root.val + l + r);
        return root.val + Math.max(l, r);
    }

}
