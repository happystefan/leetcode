package Q001_Q300;

import java.util.LinkedList;
import java.util.List;

public class Q113_Path_Sum_II {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(ans, new LinkedList<Integer>(), root, sum);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> path, TreeNode root, int sum) {
        if (root == null) return;

        List<Integer> npath = new LinkedList<>(path);
        npath.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            ans.add(npath);
            return;
        }

        dfs(ans, npath, root.left, sum-root.val);
        dfs(ans, npath, root.right, sum-root.val);
    }

}
