package tree;

public class Q104_Maximum_Depth_of_Binary_Tree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        int[] result = new int[1];
        dfs(result, root, 0);
        return result[0];
    }

    private void dfs(int[] result, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        result[0] = Math.max(result[0], depth+1);
        dfs(result, root.left, depth+1);
        dfs(result, root.right,depth+1);
    }

}
