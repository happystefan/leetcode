package archive.tree;

import java.util.HashMap;
import java.util.Map;

public class Q663_Equal_Tree_Partition_B {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = treeSum(map, root);
        if (sum == 0) {
            return map.get(0) > 1;
        }
        return sum%2 == 0 && map.containsKey(sum/2);
    }

    private int treeSum(Map<Integer, Integer> map, TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            map.put(root.val, map.getOrDefault(root.val, 0)+1);
            return root.val;
        }
        int l = treeSum(map, root.left);
        int r = treeSum(map, root.right);
        map.put(l+r+root.val, map.getOrDefault(l+r+root.val, 0)+1);

        return l+r+root.val;
    }

}
