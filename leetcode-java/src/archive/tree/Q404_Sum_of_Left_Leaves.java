package archive.tree;

public class Q404_Sum_of_Left_Leaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode r = root;
        while (r.left != null || r.right != null) {
            if (r.right != null) r = r.right;
            else r = r.left;
        }
        int[] sum = new int[1];
        dfs(root.left, sum, true);
        dfs(root.right, sum,false);
        return sum[0];
    }
    private void dfs(TreeNode root, int[] sum, boolean l) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && l) {
            sum[0] += root.val;
            return;
        }
        dfs(root.left, sum, true);
        dfs(root.right, sum,false);
    }

}
