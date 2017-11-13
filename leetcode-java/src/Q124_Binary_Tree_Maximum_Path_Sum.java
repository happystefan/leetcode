public class Q124_Binary_Tree_Maximum_Path_Sum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    public int maxPath(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(maxPath(root.left), 0);
        int right = Math.max(maxPath(root.right), 0);
        max = Math.max(max, left+right+root.val);
        return Math.max(left, right)+root.val;
    }

}
