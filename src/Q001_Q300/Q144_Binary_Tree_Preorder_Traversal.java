package Q001_Q300;

import java.util.LinkedList;
import java.util.List;

public class Q144_Binary_Tree_Preorder_Traversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfs(ans, root);
        return ans;
    }

    public void dfs(List<Integer> ans, TreeNode root) {
        if (root == null) return;
        ans.add(root.val);
        dfs(ans, root.left);
        dfs(ans, root.right);
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
