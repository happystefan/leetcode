package archive.tree;

public class Q538_Convert_BST_to_Greater_Tree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode convertBST(TreeNode root) {
        convert(root, new int[1]);
        return root;
    }

    private void convert(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }
        convert(root.right, sum);
        sum[0] += root.val;
        root.val = sum[0];
        convert(root.left, sum);
    }

}
