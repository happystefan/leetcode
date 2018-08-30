package facebook.tree;

import java.util.*;

public class Q113_Path_Sum_II {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), root, sum);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> path, TreeNode root, int sum) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new LinkedList<>(path));
        }
        dfs(result, path, root.left, sum-root.val);
        dfs(result, path, root.right, sum-root.val);
        path.remove(path.size()-1);
    }

}
