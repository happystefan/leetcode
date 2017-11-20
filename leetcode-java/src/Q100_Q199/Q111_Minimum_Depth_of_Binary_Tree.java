package Q100_Q199;

public class Q111_Minimum_Depth_of_Binary_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null) return Math.max(minDepth(root.left), minDepth(root.right))+1;
        return  Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}