package Y2019.Q0001_Q0300;

public class Q0104_Maximum_Depth_of_Binary_Tree {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int maxDepth_vs(TreeNode root) {
        int[] result = new int[]{0};
        dfs(result, 0, root);
        return result[0];
    }

    private void dfs(int[] result, int depth, TreeNode root) {
        if (root == null) return;
        result[0] = Math.max(result[0], depth + 1);
        dfs(result, depth + 1, root.left);
        dfs(result, depth + 1, root.right);
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) return depth;
        return Math.max(dfs(root.left, depth + 1), dfs(root.right, depth + 1));
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
