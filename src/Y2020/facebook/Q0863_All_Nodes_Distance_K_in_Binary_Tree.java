package Y2020.facebook;

import java.util.*;

public class Q0863_All_Nodes_Distance_K_in_Binary_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(map, root, null);
        Queue<TreeNode> Q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        Q.add(target);
        visited.add(target);
        visited.add(null);

        List<Integer> rslt = new LinkedList<>();
        while (!Q.isEmpty()) {
            if (K == 0) {
                while (!Q.isEmpty()) rslt.add(Q.poll().val);
                return rslt;
            }
            int size = Q.size();
            while (size-- > 0) {
                TreeNode curr = Q.poll();
                for (TreeNode next : Arrays.asList(curr.left, curr.right, map.get(curr))) {
                    if (visited.contains(next)) continue;
                    Q.add(next);
                    visited.add(next);
                }
            }
            K--;
        }
        return rslt;
    }

    private void dfs(Map<TreeNode, TreeNode> map, TreeNode root, TreeNode prev) {
        if (root == null) return;
        map.put(root, prev);
        dfs(map, root.left, root);
        dfs(map, root.right, root);
    }

}
