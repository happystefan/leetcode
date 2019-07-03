package Y2019.misc;

import java.util.HashSet;
import java.util.Set;

public class Q003_Remove_An_Edge_To_Recover_Binary_Tree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public void removeAnEdgeToRecoverBinaryTree(TreeNode root) {
        Set<TreeNode> visited = new HashSet<>();
        dfs(root, visited);
    }

    private void dfs(TreeNode root, Set<TreeNode> visited) {
        if (root == null) return;
        visited.add(root);
        if (visited.contains(root.left)) {
            root.left = null;
            return;
        }
        if (visited.contains(root.right)) {
            root.right = null;
            return;
        }
        dfs(root.left, visited);
        dfs(root.right, visited);
    }

}
