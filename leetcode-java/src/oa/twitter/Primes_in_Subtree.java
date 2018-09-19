package oa.twitter;

import java.util.*;

public class Primes_in_Subtree {

    static List<Integer> primeQuery(int n, List<Integer> first, List<Integer> second, List<Integer> values, List<Integer> queries) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<TreeNode, Set<TreeNode>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i+1, new TreeNode(values.get(i)));
            graph.computeIfAbsent(map.get(i+1), k -> new HashSet<>());
        }

        for (int i = 0; i < first.size(); i++) {
            TreeNode u = map.get(first.get(i)), v = map.get(second.get(i));
            if (u == v) continue;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        buildTree(map.get(1), graph, null);

        Map<TreeNode, Integer> memo = new HashMap<>();
        dfs(map.get(1), memo);
        List<Integer> result = new LinkedList<>();
        for (int qry : queries) {
            result.add(memo.get(map.get(qry)));
        }
        return result;
    }

    static void buildTree(TreeNode root, Map<TreeNode, Set<TreeNode>> graph, TreeNode parent) {
        for (TreeNode node : graph.get(root)) {
            if (node == parent) continue;
            root.child.add(node);
        }
        for (TreeNode node : root.child) {
            buildTree(node, graph, root);
        }
    }

    static int dfs(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int result = isPrime(root.val) ? 1 : 0;
        for (TreeNode node : root.child) {
            result += dfs(node, memo);
        }
        memo.put(root, result);
        return result;
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num %2 == 0) return false;
        for (int i = 3; i*i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    static class TreeNode {
        int val;
        Set<TreeNode> child = new HashSet<>();
        TreeNode(int val) {
            this.val = val;
        }
    }


}
