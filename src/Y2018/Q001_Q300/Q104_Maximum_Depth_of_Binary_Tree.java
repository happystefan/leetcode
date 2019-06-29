package Y2018.Q001_Q300;

public class Q104_Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int level) {
        if (root == null) return level;
        return Math.max(Math.max(level, dfs(root.left, level + 1)), dfs(root.right, level + 1));
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
