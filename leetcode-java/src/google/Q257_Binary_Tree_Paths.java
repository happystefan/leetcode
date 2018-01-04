package google;

import java.util.LinkedList;
import java.util.List;

public class Q257_Binary_Tree_Paths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<>();
        dfs(root, "", ans);
        return ans;
    }

    private void dfs(TreeNode root, String pre, List<String> ans) {
        if (root == null) return;
        String cur = pre.equals("") ? String.valueOf(root.val) : pre+"->"+String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            ans.add(cur);
            return;
        }
        if (root.left != null) dfs(root.left, cur, ans);
        if (root.right != null) dfs(root.right, cur, ans);
    }

}
