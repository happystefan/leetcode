package tree;

public class Q671_Second_Minimum_Node_In_a_Binary_Tree {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }
        int l = root.val == root.left.val ? findSecondMinimumValue(root.left) : root.left.val;
        int r = root.val == root.right.val ? findSecondMinimumValue(root.right) : root.right.val;
        return l == -1 || r == -1 ? Math.max(l, r) : Math.min(l, r);
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
