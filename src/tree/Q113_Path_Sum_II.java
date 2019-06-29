package tree;

import java.util.LinkedList;
import java.util.List;

public class Q113_Path_Sum_II {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, root, new LinkedList<>(), sum);
        return result;
    }

    private void dfs(List<List<Integer>> result, TreeNode root, List<Integer> path, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val && root.left == null && root.right == null) {
            result.add(path);
        }
        List<Integer> npath = new LinkedList<>(path);
        npath.add(root.val);
        dfs(result, root.left, path, sum - root.val);
        dfs(result, root.right, path, sum - root.val);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
