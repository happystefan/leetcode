package google;

public class Q230_Kth_Smallest_Element_in_a_BST {

    public int kthSmallest(TreeNode root, int k) {
        int left = dfs(root.left);
        if (left >= k) return kthSmallest(root.left, k);
        if (left + 1 < k) return kthSmallest(root.right, k - left - 1);
        return root.val;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        return 1 + dfs(root.left) + dfs(root.right);
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
