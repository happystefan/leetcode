package Y2018.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q652_Find_Duplicate_Subtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        dfs(result, new HashMap<>(), root);
        return result;
    }

    private String dfs(List<TreeNode> result, Map<String, Integer> map, TreeNode root) {
        if (root == null) {
            return "#";
        }
        String str = root.val + "," + dfs(result, map, root.left) + "," + dfs(result, map, root.right);
        if (map.containsKey(str) && map.get(str) == 1) {
            result.add(root);
        }
        map.put(str, map.getOrDefault(str, 0) + 1);
        return str;
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
