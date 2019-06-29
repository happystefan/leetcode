package Y2018.facebook;

public class Q099_Recover_Binary_Search_Tree {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);

        if (first == null && prev != null && prev.val > root.val) {
            first = prev;
        }
        if (first != null && prev != null && prev.val > root.val) {
            second = root;
        }
        prev = root;

        dfs(root.right);
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
