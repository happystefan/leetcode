package Y2018.tree;

public class Q114_Flatten_Binary_Tree_to_Linked_List {

    public void flatten(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        root.left = null;
        root.right = left;
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
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
