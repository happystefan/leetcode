package Y2018.tree;

public class Q549_Binary_Tree_Longest_Consecutive_Sequence_II {

    public int longestConsecutive(TreeNode root) {
        int[] result = new int[1];
        dfs(result, root);
        return result[0];
    }

    private int[] dfs(int[] result, TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(result, root.left);
        int[] r = dfs(result, root.right);
        int increasing = Math.max(root.left != null && root.left.val == root.val + 1 ? l[0] + 1 : 0,
                root.right != null && root.right.val == root.val + 1 ? r[0] + 1 : 0);
        int decreasing = Math.max(root.left != null && root.left.val == root.val - 1 ? l[1] + 1 : 0,
                root.right != null && root.right.val == root.val - 1 ? r[1] + 1 : 0);
        result[0] = Math.max(result[0], 1 + increasing + decreasing);
        return new int[]{increasing, decreasing};
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
