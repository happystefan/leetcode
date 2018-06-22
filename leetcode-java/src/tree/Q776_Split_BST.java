package tree;

public class Q776_Split_BST {

    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        if (root.val > V) {
            TreeNode[] result = splitBST(root.left, V);
            root.left = result[1];
            result[1] = root;
            return result;
        } else {
            TreeNode[] result = splitBST(root.right, V);
            root.right = result[0];
            result[0] = root;
            return result;
        }
    }

}
