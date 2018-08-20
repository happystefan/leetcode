package archive.Q001_Q300;

import java.util.ArrayList;
import java.util.List;

public class Q102_Binary_Tree_Level_Order_Traversal {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        bfs(root, ans, 0);
        return ans;
    }

    public void bfs(TreeNode root, List<List<Integer>> ans, int height) {
        if (root == null) return;
        if (height >= ans.size()) {
            ans.add(new ArrayList<>());
        }
        ans.get(height).add(root.val);
        bfs(root.left, ans, height+1);
        bfs(root.right, ans, height+1);
    }
}
