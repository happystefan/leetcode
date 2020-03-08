package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0113_Path_Sum_II {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rslt = new LinkedList<>();
        if (root == null) return rslt;
        dfs(rslt, new LinkedList<>(), root, sum);
        return rslt;
    }

    private void dfs(List<List<Integer>> rslt, List<Integer> path, TreeNode root, int sum) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) rslt.add(new LinkedList<>(path));
        }
        if (root.left != null) dfs(rslt, path, root.left, sum - root.val);
        if (root.right != null) dfs(rslt, path, root.right, sum - root.val);
        path.remove(path.size() - 1);
    }

}
