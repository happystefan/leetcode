package archive.bfs_dfs;

import java.util.*;

public class Q126_Word_Ladder_II_C {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new LinkedList<>();
        }
        Map<String, Set<String>> map = new HashMap<>(); // word to index map
        wordList.add(beginWord);
        int n = wordList.size();
        for (int i = 0; i < n; i++) {
            String a = wordList.get(i);
            for (int j = i+1; j < n; j++) {
                String b = wordList.get(j);
                if (isNeighbor(a, b)) {
                    map.computeIfAbsent(a, k-> new HashSet<>());
                    map.computeIfAbsent(b, k-> new HashSet<>());
                    map.get(a).add(b);
                    map.get(b).add(a);
                }
            }
        }

        Map<String, Integer> fmemo = new HashMap<>();
        Map<String, Integer> bmemo = new HashMap<>();
        Queue<Node> FQ = new LinkedList<>();
        Queue<Node> BQ = new LinkedList<>();
        FQ.offer(new Node(beginWord, null));
        BQ.offer(new Node(endWord, null));

        List<Node[]> list = new LinkedList<>();
        int steps = 0;
        while (!FQ.isEmpty() || !BQ.isEmpty()) {
            List<Node> fnodes = new LinkedList<>(FQ);
            List<Node> bnodes = new LinkedList<>(BQ);

            list = meet(FQ, BQ);
            if (list.size() != 0){
                break;
            }
            FQ.clear();
            for (Node node : fnodes) {
                if (fmemo.containsKey(node.curr) && fmemo.get(node.curr) < steps) {
                    continue;
                }
                fmemo.put(node.curr, steps);
                if (!map.containsKey(node.curr)) {
                    continue;
                }
                for (String next : map.get(node.curr)) {
                    FQ.offer(new Node(next, node));
                }
            }
            list = meet(FQ, BQ);
            if (list.size() != 0){
                break;
            }
            BQ.clear();
            for (Node node : bnodes) {
                if (bmemo.containsKey(node.curr) && bmemo.get(node.curr) < steps) {
                    continue;
                }
                bmemo.put(node.curr, steps);
                if (!map.containsKey(node.curr)) {
                    continue;
                }
                for (String next : map.get(node.curr)) {
                    BQ.offer(new Node(next, node));
                }
            }
            list = meet(FQ, BQ);
            if (list.size() != 0){
                break;
            }
            steps++;
        }
        List<List<String>> result = new LinkedList<>();
        for (Node[] pair: list) {
            List<String> path = new LinkedList<>();
            Node fnode = pair[0], bnode = pair[1];
            while (fnode != null) {
                path.add(0, fnode.curr);
                fnode = fnode.prev;
            }
            bnode = bnode.prev;
            while (bnode != null) {
                path.add(bnode.curr);
                bnode = bnode.prev;
            }

            result.add(path);
        }
        return result;
    }

    private List<Node[]> meet(Queue<Node> FQ, Queue<Node> BQ) {
        List<Node[]> result = new LinkedList<>();
        Set<String> fset = new HashSet<>();
        Set<String> bset = new HashSet<>();
        for (Node node : FQ) fset.add(node.curr);
        for (Node node : BQ) bset.add(node.curr);
        fset.retainAll(bset);
        if (fset.isEmpty()) {
            return result;
        }
        for (String word : fset) {
            for (Node fnode : FQ) {
                if (!fnode.curr.equals(word)) {
                    continue;
                }
                for (Node bnode : BQ) {
                    if (!bnode.curr.equals(word)) {
                        continue;
                    }
                    result.add(new Node[]{fnode, bnode});
                }
            }
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
        public Node(String c, Node p) {
            curr = c;
            prev = p;
        }
    }


}
