package Y2018.bfs_dfs;

import java.util.*;

public class Q126_Word_Ladder_II_B {

    Map<String, Set<String>> map = new HashMap<>(); // word to index map
    Map<String, Integer> memo = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new LinkedList<>();
        }

        wordList.add(beginWord);
        int n = wordList.size();
        for (int i = 0; i < n; i++) {
            String a = wordList.get(i);
            for (int j = i + 1; j < n; j++) {
                String b = wordList.get(j);
                if (isNeighbor(a, b)) {
                    map.computeIfAbsent(a, k -> new HashSet<>());
                    map.computeIfAbsent(b, k -> new HashSet<>());
                    map.get(a).add(b);
                    map.get(b).add(a);
                }
            }
        }

        List<Node> list = new LinkedList<>();
        PriorityQueue<Node> Q = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        Q.offer(new Node(beginWord, null, 0));
        int steps = Integer.MAX_VALUE;
        while (!Q.isEmpty()) {
            Node node = Q.poll();
            if (node.dist > steps) {
                break;
            }
            if (memo.containsKey(node.curr) && memo.get(node.curr) < node.dist) {
                continue;
            }
            memo.put(node.curr, node.dist);

            if (node.curr.equals(endWord)) {
                if (node.dist < steps) {
                    steps = node.dist;
                    list.clear();
                }
                list.add(node);
                continue;
            }
            if (!map.containsKey(node.curr)) {
                continue;
            }
            for (String next : map.get(node.curr)) {
                Q.offer(new Node(next, node, node.dist + 1));
            }
        }
        List<List<String>> result = new LinkedList<>();
        for (Node node : list) {
            List<String> path = new LinkedList<>();
            while (node != null) {
                path.add(0, node.curr);
                node = node.prev;
            }
            result.add(path);
        }
        return result;
    }


    private boolean isNeighbor(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }

    class Node {
        String curr;
        Node prev;
        int dist;

        public Node(String c, Node p, int d) {
            curr = c;
            prev = p;
            dist = d;
        }
    }

}
