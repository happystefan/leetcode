package facebook.tree;

public class Q250_Count_Univalue_Subtrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int countUnivalSubtrees(TreeNode root) {
        int[] result = new int[]{0};
        dfs(result, root);
        return result[0];
    }

    private boolean dfs(int[] result, TreeNode root) {
        if (root == null) return false;
        boolean l = dfs(result, root.left);
        boolean r = dfs(result, root.right);
        if ((root.left == null || root.left.val == root.val && l)
                && (root.right == null || root.right.val == root.val && r)) {
            result[0]++;
            return true;
        }
        return false;
    }

}
