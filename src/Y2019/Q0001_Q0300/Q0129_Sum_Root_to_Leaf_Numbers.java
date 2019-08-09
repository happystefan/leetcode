package Y2019.Q0001_Q0300;

public class Q0129_Sum_Root_to_Leaf_Numbers {

    private int result = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int val) {
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            result += val;
        }
        if (root.left != null) dfs(root.left, val);
        if (root.right != null) dfs(root.right, val);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
