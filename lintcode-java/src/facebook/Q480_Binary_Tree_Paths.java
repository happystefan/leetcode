package facebook;

import java.util.LinkedList;
import java.util.List;

public class Q480_Binary_Tree_Paths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        dfs(result, root, "");
        return result;
    }

    private void dfs(List<String> result, TreeNode root, String str) {
        if (root == null) {
            return;
        }
        str += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            result.add(str);
            return;
        }
        str += "->";
        if (root.left != null) {
            dfs(result, root.left, str);
        }
        if (root.right != null) {
            dfs(result, root.right, str);
        }
    }

}
