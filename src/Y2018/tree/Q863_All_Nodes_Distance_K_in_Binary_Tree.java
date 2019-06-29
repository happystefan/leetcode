package Y2018.tree;

import java.util.*;

public class Q863_All_Nodes_Distance_K_in_Binary_Tree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(map, root, null);
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        visited.add(null);
        List<Integer> result = new LinkedList<>();
        while (K-- > 0) {
            int size = Q.size();
            while (size-- > 0) {
                TreeNode curr = Q.poll();
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    Q.offer(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    Q.offer(curr.right);
                }
                if (map.containsKey(curr) && map.get(curr) != null && !visited.contains(map.get(curr))) {
                    visited.add(map.get(curr));
                    Q.offer(map.get(curr));
                }
            }
        }
        while (!Q.isEmpty()) {
            result.add(Q.poll().val);
        }
        return result;
    }

    private void dfs(Map<TreeNode, TreeNode> map, TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        map.put(root, parent);
        dfs(map, root.left, root);
        dfs(map, root.right, root);
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
