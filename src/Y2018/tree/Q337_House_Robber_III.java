package Y2018.tree;

public class Q337_House_Robber_III {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(robInclude(root), robExclude(root));
    }

    private int robInclude(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + robExclude(root.left) + robExclude(root.right);
    }

    private int robExclude(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return rob(root.left) + rob(root.right);
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
