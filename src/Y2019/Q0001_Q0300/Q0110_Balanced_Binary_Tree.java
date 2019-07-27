package Y2019.Q0001_Q0300;

public class Q0110_Balanced_Binary_Tree {

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int lh = height(root.left), rh = height(root.right);
        return (Math.abs(lh - rh) > 1 || lh == -1 || rh == -1) ? -1 : 1 + Math.max(lh, rh);
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
