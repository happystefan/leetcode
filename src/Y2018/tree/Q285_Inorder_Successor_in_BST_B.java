package Y2018.tree;

public class Q285_Inorder_Successor_in_BST_B {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode l = inorderSuccessor(root.left, p);
        return l == null ? root : l;
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
