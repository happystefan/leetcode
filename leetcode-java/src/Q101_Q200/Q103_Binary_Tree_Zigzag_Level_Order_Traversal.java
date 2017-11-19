package Q101_Q200;

import java.util.LinkedList;
import java.util.List;

public class Q103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        bfs(root, ans, 0);
        return ans;
    }

    public void bfs(TreeNode root, List<List<Integer>> ans, int height) {
        if (root == null) return;
        if (height >= ans.size()) {
            ans.add(new LinkedList<>());
        }

        if (height%2 == 0) {
            ans.get(height).add(0, root.val);
        } else {
            ans.get(height).add(root.val);
        }

        bfs(root.left, ans, height+1);
        bfs(root.right, ans, height+1);
    }
}
