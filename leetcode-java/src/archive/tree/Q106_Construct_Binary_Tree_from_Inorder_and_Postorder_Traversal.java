package archive.tree;

import java.util.Arrays;

public class Q106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        if (postorder.length == 1) {
            return root;
        }
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length-1]) {
                break;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        root.right= buildTree(Arrays.copyOfRange(inorder, i+1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length-1));
        return root;
    }

}
