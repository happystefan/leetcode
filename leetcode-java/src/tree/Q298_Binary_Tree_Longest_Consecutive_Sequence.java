package tree;

import java.util.*;
import java.lang.Math;

public class Q298_Binary_Tree_Longest_Consecutive_Sequence {

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
        int[] result = new int[1];
        dfs(result, root, root.val, 0);
        return result[0];
    }

    private void dfs(int[] result, TreeNode root, int val, int len) {
        if (root == null) {
            return;
        }
        if (root.val == val) {
            len++;
        } 
        result[0] = Math.max(result[0], len);
        if (root.val != val) {
            len = 1;
        }
        dfs(result, root.left, root.val+1, len);
        dfs(result, root.right,root.val+1, len);
    }

}