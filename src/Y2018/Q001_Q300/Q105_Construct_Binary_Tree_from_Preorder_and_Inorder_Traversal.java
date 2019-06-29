package Y2018.Q001_Q300;

import java.util.Arrays;

public class Q105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) return root;

        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) break;
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));

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
