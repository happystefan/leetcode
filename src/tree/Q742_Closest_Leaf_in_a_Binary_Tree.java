package tree;

import java.util.*;

public class Q742_Closest_Leaf_in_a_Binary_Tree {

    public int findClosestLeaf(TreeNode root, int k) {
        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        Set<Integer> leaves = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        buildGraph(graph, leaves, root, null);

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(k);
        visited.add(k);

        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                int c = Q.poll();
                visited.add(c);
                if (leaves.contains(c)) {
                    return c;
                }
                for (int i : graph.get(c)) {
                    if (visited.contains(i)) {
                        continue;
                    }
                    visited.add(i);
                    Q.offer(i);
                }
            }
        }
        return 0;
    }

    private void buildGraph(Map<Integer, LinkedList<Integer>> graph, Set<Integer> leaves, TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        graph.computeIfAbsent(root.val, k -> new LinkedList<>());
        if (parent != null) {
            graph.get(root.val).add(parent.val);
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        if (root.left != null) {
            graph.get(root.val).add(root.left.val);
            buildGraph(graph, leaves, root.left, root);
        }
        if (root.right != null) {
            graph.get(root.val).add(root.right.val);
            buildGraph(graph, leaves, root.right, root);
        }
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
