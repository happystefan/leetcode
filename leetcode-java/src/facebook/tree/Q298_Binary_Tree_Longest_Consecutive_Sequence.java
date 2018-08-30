package facebook.tree;

public class Q298_Binary_Tree_Longest_Consecutive_Sequence {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root.left, root.val+1, 1), dfs(root.right, root.val+1, 1));
    }

    private int dfs(TreeNode root, int target, int len) {
        if (root == null) return len;
        len = root.val == target ? len+1 : 1;
        return Math.max(len, Math.max(dfs(root.left, root.val+1, len), dfs(root.right, root.val+1, len)));
    }

}
