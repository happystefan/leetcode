package vmware;

import java.util.*;

public class Q126_Word_Ladder_II {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return result;

        Queue<Node> Q = new LinkedList<>();
        Q.offer(new Node(beginWord, null, 0));
        Map<String, Integer> memo = new HashMap<>();

        List<Node> list = new LinkedList<>();
        int dist = 0;
        while (!Q.isEmpty()) {
            dist++;
            int size = Q.size();
            while (size-- > 0) {
                Node node = Q.poll();
                String curr = node.curr;
                memo.put(curr, node.dist);
                for (int i = 0; i < curr.length(); i++) {
                    char[] ss = curr.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        ss[i] = c;
                        String next = new String(ss);
                        if (next.equals(endWord)) {
                            list.add(new Node(next, node, dist));
                            continue;
                        }
                        if (!wordSet.contains(next) || memo.containsKey(next) && memo.get(next) < dist) {
                            continue;
                        }
                        Q.offer(new Node(next, node, dist));
                    }
                }
            }
            if (!list.isEmpty()) break;
        }

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

    class Node {
        String curr;
        Node prev;
        int dist;
        public Node(String curr, Node prev, int dist) {
            this.curr = curr;
            this.prev = prev;
            this.dist = dist;
        }
    }

}
