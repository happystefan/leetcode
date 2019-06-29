package tree;

public class Q563_Binary_Tree_Tilt {

    public int findTilt(TreeNode root) {
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
        result[0] += Math.abs(l - r);
        return l + r + root.val;
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
