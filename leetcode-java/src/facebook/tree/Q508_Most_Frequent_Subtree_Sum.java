package facebook.tree;

import java.util.*;

public class Q508_Most_Frequent_Subtree_Sum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        treeSum(root, map);
        List<Integer> result = new LinkedList<>();
        int max = 0;
        for (int sum : map.keySet()) {
            if (map.get(sum) >= max) {
                if (map.get(sum) > max) result.clear();
                result.add(sum);
                max = map.get(sum);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int treeSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int l = treeSum(root.left, map);
        int r = treeSum(root.right,map);
        int sum = l+r+root.val;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        return sum;
    }
}
