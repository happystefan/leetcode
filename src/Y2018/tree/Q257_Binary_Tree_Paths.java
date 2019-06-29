package Y2018.tree;

import java.util.LinkedList;
import java.util.List;

public class Q257_Binary_Tree_Paths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        dfs(result, String.valueOf(root.val), root);
        return result;
    }

    private void dfs(List<String> result, String path, TreeNode root) {
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) dfs(result, path + "->" + root.left.val, root.left);
        if (root.right != null) dfs(result, path + "->" + root.right.val, root.right);
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
