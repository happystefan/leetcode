package Y2019.Q0001_Q0300;

import java.util.HashMap;
import java.util.Map;

public class Q0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    Map<Integer, Integer> map = new HashMap<>();
    int i = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        i = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int l, int r) {
        if (l > r) return null;
        int val = postorder[i--];
        TreeNode root = new TreeNode(val);
        if (l == r) return root;
        root.right = build(inorder, postorder, map.get(val) + 1, r);
        root.left = build(inorder, postorder, l, map.get(val) - 1);
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
