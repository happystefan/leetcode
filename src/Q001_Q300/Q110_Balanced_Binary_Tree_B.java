package Q001_Q300;

public class Q110_Balanced_Binary_Tree_B {

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        if (Math.abs(lheight - rheight) > 1 || lheight == -1 || rheight == -1) return -1;
        return Math.max(lheight, rheight) + 1;
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
