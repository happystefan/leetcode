package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q508_Most_Frequent_Subtree_Sum {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(map, root);
        int max_cnt = 0;
        List<Integer> sums = new LinkedList<>();
        for (int i : map.keySet()) {
            int cnt = map.get(i);
            if (cnt >= max_cnt) {
                if (cnt > max_cnt) {
                    sums.clear();
                }
                sums.add(i);
                max_cnt = cnt;
            }
        }
        int[] result = new int[sums.size()];
        int i = 0;
        for (int sum : sums) {
            result[i++] = sum;
        }
        return result;
    }

    private int dfs(Map<Integer, Integer> map, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(map, root.left);
        int r = dfs(map, root.right);
        int sum = l + r + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
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
