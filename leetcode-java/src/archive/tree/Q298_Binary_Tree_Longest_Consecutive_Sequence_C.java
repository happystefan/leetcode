package archive.tree;

public class Q298_Binary_Tree_Longest_Consecutive_Sequence_C {

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
        dfs(result, root);
        return result[0];
    }

    private int dfs(int[] result, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(result, root.left);
        int r = dfs(result, root.right);
        if (root.left != null && root.val+1 == root.left.val) {
            l += 1;
        } else {
            l = 1;
        }

        if (root.right != null && root.val+1 == root.right.val) {
            r += 1;
        } else {
            r = 1;
        }

        result[0] = Math.max(result[0], Math.max(l, r));
        return Math.max(l, r);
    }

}
