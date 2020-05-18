package Y2020.facebook;

public class Q1026_Maximum_Difference_Between_Node_and_Ancestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        int[] rslt = new int[]{0};
        TreeNode dummy = new TreeNode(root.val);
        dummy.left = root;
        dfs(rslt, dummy, new int[]{dummy.val, dummy.val});
        return rslt[0];
    }

    private void dfs(int[] rslt, TreeNode root, int[] minmax) {
        if (root == null) return;
        int min = minmax[0], max = minmax[1];
        rslt[0] = Math.max(rslt[0], Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
        minmax[0] = Math.min(min, root.val);
        minmax[1] = Math.max(max, root.val);
        dfs(rslt, root.left, minmax);
        dfs(rslt, root.right, minmax);
        minmax[0] = min;
        minmax[1] = max;
    }

}
