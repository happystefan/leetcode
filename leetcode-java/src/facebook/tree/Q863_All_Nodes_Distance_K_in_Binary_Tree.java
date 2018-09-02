package facebook.tree;

import java.util.*;

public class Q863_All_Nodes_Distance_K_in_Binary_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        buildGraph(root, null, map);
        Queue<TreeNode> Q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        visited.add(null);
        Q.offer(target);
        while (K-- > 0) {
            int size = Q.size();
            while (size-- > 0) {
                TreeNode curr = Q.poll();
                visited.add(curr);
                for (TreeNode node : Arrays.asList(map.get(curr), curr.left, curr.right)) {
                    if (!visited.contains(node)) Q.offer(node);
                }
            }
        }
        while (!Q.isEmpty()) result.add(Q.poll().val);
        return result;
    }

    private void buildGraph(TreeNode root, TreeNode prev, Map<TreeNode, TreeNode> map) {
        if (root == null) return;
        map.put(root, prev);
        buildGraph(root.left, root, map);
        buildGraph(root.right,root, map);
    }

}
