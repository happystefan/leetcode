package Y2019.Q0001_Q0300;


import java.util.LinkedList;
import java.util.List;

public class Q0257_Binary_Tree_Paths {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) return result;
        dfs(result, root, new LinkedList<>());
        return result;
    }

    private void dfs(List<String> result, TreeNode root, List<String> path) {
        path.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            result.add(String.join("->", path));
            return;
        }
        if (root.left != null) dfs(result, root.left, new LinkedList<>(path));
        if (root.right != null) dfs(result, root.right, new LinkedList<>(path));
    }

}
