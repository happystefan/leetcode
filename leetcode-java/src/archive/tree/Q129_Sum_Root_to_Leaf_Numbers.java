package archive.tree;

public class Q129_Sum_Root_to_Leaf_Numbers {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs (TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return sum*10+root.val;
        }
        return dfs(root.left, sum*10+root.val) + dfs(root.right, sum*10+root.val);
    }

}
