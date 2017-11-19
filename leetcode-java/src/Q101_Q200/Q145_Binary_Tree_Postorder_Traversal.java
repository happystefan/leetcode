package Q101_Q200;

import java.util.LinkedList;
import java.util.List;

public class Q145_Binary_Tree_Postorder_Traversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfs(ans, root);
        return ans;
    }

    public void dfs(List<Integer> ans, TreeNode root) {
        if (root == null) return;
        dfs(ans, root.left);
        dfs(ans, root.right);
        ans.add(root.val);
    }

}
