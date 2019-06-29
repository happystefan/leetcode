package Q001_Q300;

public class Q230_Kth_Smallest_Element_in_a_BST {

    public int kthSmallest(TreeNode root, int k) {
        int leftNum = dfs(root.left);
        if (leftNum >= k) return kthSmallest(root.left, k);
        else if (leftNum + 1 < k) return kthSmallest(root.right, k - leftNum - 1);
        else return root.val;
    }

    public int dfs(TreeNode root) {
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
