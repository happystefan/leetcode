package Y2020.facebook;

public class Q0230_Kth_Smallest_Element_in_a_BST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] rslt = new int[]{0};
        dfs(root, rslt, new int[]{k});
        return rslt[0];
    }

    private void dfs(TreeNode root, int[] rslt, int[] k) {
        if (root == null) return;
        dfs(root.left, rslt, k);
        k[0]--;
        if (k[0] == 0) {
            rslt[0] = root.val;
            return;
        }
        dfs(root.right, rslt, k);
    }

}
