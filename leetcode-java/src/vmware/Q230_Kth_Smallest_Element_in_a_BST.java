package vmware;

public class Q230_Kth_Smallest_Element_in_a_BST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[]{0};
        dfs(root, result, new int[]{k});
        return result[0];
    }

    private void dfs(TreeNode root, int[] result, int[] k) {
        if (root == null) return;
        dfs(root.left, result, k);

        k[0]--;
        if (k[0] == 0) {
            result[0] = root.val;
            return;
        }

        dfs(root.right, result, k);
    }

}
