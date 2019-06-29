package Y2018.tree;

public class Q669_Trim_a_Binary_Search_Tree {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        if (L > R) {
            return root;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
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
