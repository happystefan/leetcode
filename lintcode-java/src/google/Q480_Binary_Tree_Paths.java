package google;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q480_Binary_Tree_Paths {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<>();
        dfs(ans, "", root);
        return ans;
    }

    public void dfs(List<String> ans, String path, TreeNode root) {
        if (root == null) return;
        String npath = path.equals("") ? String.format("%d", root.val) : String.format("%s->%d", path, root.val);
        if (root.left == null && root.right == null) {
            ans.add(npath);
            return;
        }
        if (root.left != null) dfs(ans, npath, root.left);
        if (root.right != null) dfs(ans, npath, root.right);
    }

}
