package Y2019.Q0001_Q0300;

import java.util.LinkedList;
import java.util.List;

public class Q0113_Path_Sum_II {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, root, new LinkedList<>(), sum);
        return result;
    }

    private void dfs(List<List<Integer>> result, TreeNode root, List<Integer> path, int sum) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList<>(path));
        }
        if (root.left != null) dfs(result, root.left, path, sum - root.val);
        if (root.right != null) dfs(result, root.right, path, sum - root.val);
        path.remove(path.size() - 1);
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
