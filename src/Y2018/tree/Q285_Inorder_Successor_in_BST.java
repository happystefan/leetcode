package Y2018.tree;

public class Q285_Inorder_Successor_in_BST {
    boolean flag = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode l = inorderSuccessor(root.left, p);
        if (l != null) {
            return l;
        }
        if (flag) {
            return root;
        }
        if (root == p) {
            flag = true;
        }
        TreeNode r = inorderSuccessor(root.right, p);
        return r;
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
