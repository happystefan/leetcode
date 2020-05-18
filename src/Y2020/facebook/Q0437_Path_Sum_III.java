package Y2020.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q0437_Path_Sum_III {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int[] rslt = new int[]{0};
        dfs(rslt, root, map, 0, sum);
        return rslt[0];
    }

    private void dfs(int[] rslt, TreeNode root, Map<Integer, Integer> map, int sum, int target) {
        if (root == null) return;

        sum += root.val;
        rslt[0] += map.getOrDefault(sum - target, 0);

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        dfs(rslt, root.left, map, sum, target);
        dfs(rslt, root.right, map, sum, target);
        map.put(sum, map.getOrDefault(sum, 0) - 1);
    }

}
