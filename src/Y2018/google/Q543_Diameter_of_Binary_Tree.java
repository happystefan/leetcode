package Y2018.google;

public class Q543_Diameter_of_Binary_Tree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left) + depth(root.right), Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
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
