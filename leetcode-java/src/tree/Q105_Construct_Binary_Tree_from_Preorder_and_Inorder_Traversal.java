package tree;

import java.util.Arrays;

public class Q105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (inorder.length == 1) {
            return root;
        }

        int idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                idx = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, idx+1), Arrays.copyOfRange(inorder, 0, idx));
        root.right= buildTree(Arrays.copyOfRange(preorder, idx+1, preorder.length), Arrays.copyOfRange(inorder, idx+1, inorder.length));
        return root;
    }

}
