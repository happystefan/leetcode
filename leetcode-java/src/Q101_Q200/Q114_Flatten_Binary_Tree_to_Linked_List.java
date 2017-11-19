package Q101_Q200;

public class Q114_Flatten_Binary_Tree_to_Linked_List {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten(left);
        flatten(right);

        root.left = null;
        root.right = left;
        while (root.right != null) root = root.right;
        root.right = right;
    }

}
