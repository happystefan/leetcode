package archive.Q001_Q300;

import java.util.LinkedList;
import java.util.List;

public class Q107_Binary_Tree_Level_Order_Traversal_II {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        bfs(ans, root, 0);
        return ans;
    }

    public void bfs(List<List<Integer>> ans, TreeNode root, int height) {
        if (root == null) return;
        if (height >= ans.size()) {
            ans.add(0, new LinkedList<>());
        }
        ans.get(ans.size()-height-1).add(root.val);
        bfs(ans, root.left, height+1);
        bfs(ans, root.right, height+1);
    }
}
