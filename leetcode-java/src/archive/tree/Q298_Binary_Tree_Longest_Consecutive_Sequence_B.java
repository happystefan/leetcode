package archive.tree;

import java.lang.Math;

public class Q298_Binary_Tree_Longest_Consecutive_Sequence_B {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left, root.val, 1), dfs(root.right, root.val, 1));
    }

    private int dfs(TreeNode root, int val, int len) {
        if (root == null) {
            return len;
        }
        if (root.val == val+1) {
            len++;
        } else {
            len = 1;
        }
        int l = dfs(root.left, root.val, len);
        int r = dfs(root.right,root.val, len);
        return Math.max(len, Math.max(l, r));
    }

}