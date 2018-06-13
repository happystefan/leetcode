package tree;

import java.util.HashMap;
import java.util.Map;

public class Q814_Binary_Tree_Pruning {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode pruneTree(TreeNode root) {
        Map<TreeNode, Boolean> map = new HashMap<>();
        traverse(map, root);
        root = pruneTree(map, root);
        return root;
    }

    private TreeNode pruneTree(Map<TreeNode, Boolean> map, TreeNode root) {
        if (map.getOrDefault(root, false)) {
            return null;
        }
        root.left = pruneTree(map, root.left);
        root.right= pruneTree(map, root.right);
        return root;
    }

    private void traverse(Map<TreeNode, Boolean> map, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == 0) {
            map.put(root, true);
            return;
        }
        traverse(map, root.left);
        traverse(map, root.right);
        boolean l = (root.left == null || map.get(root.left)) && root.val == 0;
        boolean r = (root.right== null || map.get(root.right))&& root.val == 0;
        map.put(root, l && r);
    }

}
