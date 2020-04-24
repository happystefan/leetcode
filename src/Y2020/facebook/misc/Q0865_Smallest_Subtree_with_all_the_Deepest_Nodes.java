package Y2020.facebook.misc;

import java.util.HashMap;
import java.util.Map;

public class Q0865_Smallest_Subtree_with_all_the_Deepest_Nodes {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<TreeNode, Integer> map = new HashMap<>();

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (height(root.left) == height(root.right)) return root;
        return height(root.left) > height(root.right) ? subtreeWithAllDeepest(root.left) : subtreeWithAllDeepest(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        if (!map.containsKey(root)) map.put(root, 1 + Math.max(height(root.left), height(root.right)));
        return map.get(root);
    }

}
