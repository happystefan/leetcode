package tree;

public class Q230_Kth_Smallest_Element_in_a_BST {

    int cnt = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        cnt++;
        if (cnt == k) {
            result = root.val;
            return;
        }
        dfs(root.right, k);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
