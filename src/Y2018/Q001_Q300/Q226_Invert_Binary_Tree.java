package Y2018.Q001_Q300;

public class Q226_Invert_Binary_Tree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
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
