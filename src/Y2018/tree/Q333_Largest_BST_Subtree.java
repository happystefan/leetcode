package Y2018.tree;

public class Q333_Largest_BST_Subtree {

    public int largestBSTSubtree(TreeNode root) {
        int[] result = new int[1];
        dfs(result, root);
        return result[0];
    }

    private int[] dfs(int[] result, TreeNode root) {
        if (root == null) {
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] ll = dfs(result, root.left);
        int[] rr = dfs(result, root.right);
        int[] cur = new int[3];
        if (ll[0] == -1 || root.val <= ll[2]) cur[0] = -1;
        if (rr[0] == -1 || root.val >= rr[1]) cur[0] = -1;
        if (cur[0] != -1) {
            cur[0] = ll[0] + rr[0] + 1;
            result[0] = Math.max(result[0], cur[0]);
            cur[1] = root.left == null ? root.val : ll[1];
            cur[2] = root.right == null ? root.val : rr[2];
        }
        return cur;
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
