package Y2019.Q0001_Q0300;

import java.util.HashMap;
import java.util.Map;

public class Q0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    Map<Integer, Integer> map = new HashMap<>();
    int i = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int l, int r) {
        if (l > r) return null;
        int val = preorder[i++];
        TreeNode root = new TreeNode(val);
        if (l == r) return root;
        root.left = build(preorder, inorder, l, map.get(val) - 1);
        root.right = build(preorder, inorder, map.get(val) + 1, r);
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
