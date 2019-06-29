package Y2018.facebook.tree;

import java.util.HashMap;
import java.util.Map;

public class Q437_Path_Sum_III_B {

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, 0, sum, map);
    }

    private int dfs(TreeNode root, int sum, int target, Map<Integer, Integer> map) {
        if (root == null) return 0;
        sum += root.val;
        int result = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        result += dfs(root.left, sum, target, map);
        result += dfs(root.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);
        return result;
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
