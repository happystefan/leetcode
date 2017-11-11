public class Q110_Balanced_Binary_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int ldepth = depth(root.left);
        int rdepth = depth(root.right);
        return Math.abs(ldepth-rdepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return 1+Math.max(depth(treeNode.left), depth(treeNode.right));
    }
}
