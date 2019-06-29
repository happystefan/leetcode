package Y2018.tree;

import java.util.LinkedList;
import java.util.List;

public class Q366_Find_Leaves_of_Binary_Tree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, root);
        return result;
    }

    private int dfs(List<List<Integer>> result, TreeNode root) {
        if (root == null) {
            return -1;
        }
        int l = dfs(result, root.left);
        int r = dfs(result, root.right);
        int level = Math.max(l, r) + 1;
        if (result.size() == level) {
            result.add(new LinkedList<>());
        }
        result.get(level).add(root.val);
        return level;
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
