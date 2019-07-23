package Y2019.Q0001_Q0300;

public class Q0098_Validate_Binary_Search_Tree {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long l, long r) {
        if (root == null) return true;
        if (root.val <= l || root.val >= r) return false;
        return isValid(root.left, l, root.val) && isValid(root.right, root.val, r);
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
