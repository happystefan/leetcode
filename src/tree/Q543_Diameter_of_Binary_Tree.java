package tree;

public class Q543_Diameter_of_Binary_Tree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = new int[1];
        dfs(result, root);
        return result[0] - 1;
    }

    private int dfs(int[] result, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(result, root.left);
        int r = dfs(result, root.right);
        result[0] = Math.max(result[0], l + r + 1);
        return Math.max(l + 1, r + 1);
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
