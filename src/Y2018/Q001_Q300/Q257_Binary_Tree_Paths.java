package Y2018.Q001_Q300;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingqiangliang on 12/18/17.
 */
public class Q257_Binary_Tree_Paths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<>();
        dfs(root, "", ans);
        return ans;
    }

    public void dfs(TreeNode root, String path, List<String> ans) {
        if (root == null) return;
        String npath = path.equals("") ? String.format("%d", root.val) : String.format("%s->%d", path, root.val);
        if (root.left == null && root.right == null) {
            ans.add(npath);
            return;
        }
        if (root.left != null) dfs(root.left, npath, ans);
        if (root.right != null) dfs(root.right, npath, ans);
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
