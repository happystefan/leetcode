package Y2019.Q0001_Q0300;

import java.util.*;

public class Q0126_Word_Ladder_II {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: bfs (Time Limit Exceeded)
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            wordList.add(beginWord);
            Set<String> words = new HashSet<>(wordList);
            Queue<Node> Q = new LinkedList<>();

            Node node = new Node(new LinkedList<>(), new HashSet<>());
            node.path.add(beginWord);
            node.visited.add(beginWord);

            Q.add(node);

            List<List<String>> result = new LinkedList<>();
            while (!Q.isEmpty()) {
                int size = Q.size();
                while (size-- > 0) {
                    Node curr = Q.poll();
                    List<String> path = curr.path;
                    Set<String> visited = curr.visited;
                    String word = path.get(path.size() - 1);
                    if (word.equals(endWord)) {
                        result.add(curr.path);
                        continue;
                    }
                    for (int i = 0; i < word.length(); i++) {
                        char[] ss = word.toCharArray();
                        for (char c = 'a'; c <= 'z'; c++) {
                            ss[i] = c;
                            String next = new String(ss);
                            if (word.equals(next) || visited.contains(next) || !words.contains(next)) continue;

                            Node newNode = new Node(new LinkedList<>(path), new HashSet<>(visited));
                            newNode.path.add(next);
                            newNode.visited.add(next);

                            Q.add(newNode);
                        }
                    }
                }
                if (!result.isEmpty()) break;
            }
            return result;
        }

        class Node {
            List<String> path;
            Set<String> visited;

            public Node(List<String> path, Set<String> visited) {
                this.path = path;
                this.visited = visited;
            }
        }

    }


    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: bfs with prune
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            wordList.add(beginWord);
            Set<String> words = new HashSet<>(wordList);

            Queue<List<String>> Q = new LinkedList<>();
            Map<String, Integer> memo = new HashMap<>();
            Q.add(Arrays.asList(beginWord));
            memo.put(beginWord, 0);

            List<List<String>> result = new LinkedList<>();
            int dist = 0;
            while (!Q.isEmpty()) {
                dist++;
                int size = Q.size();
                while (size-- > 0) {
                    List<String> path = Q.poll();
                    String word = path.get(path.size() - 1);
                    if (word.equals(endWord)) result.add(path);
                    if (!result.isEmpty()) continue;
                    for (int i = 0; i < word.length(); i++) {
                        char[] ss = word.toCharArray();
                        for (char c = 'a'; c <= 'z'; c++) {
                            ss[i] = c;
                            String next = new String(ss);
                            if (word.equals(next) || !words.contains(next)) continue;
                            if (memo.containsKey(next) && memo.get(next) < dist) continue;

                            List<String> newPath = new LinkedList<>(path);
                            newPath.add(next);
                            Q.add(newPath);
                            memo.put(next, dist);
                        }
                    }
                }
                if (!result.isEmpty()) break;
            }
            return result;
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 3: bi-directional bfs
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution3 {

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            wordList.add(beginWord);
            Set<String> words = new HashSet<>(wordList);
            if (!words.contains(endWord)) return new LinkedList<>();

            Queue<List<String>> FQ = new LinkedList<>();
            Queue<List<String>> BQ = new LinkedList<>();
            Map<String, Integer> fmemo = new HashMap<>();
            Map<String, Integer> bmemo = new HashMap<>();

            FQ.add(Arrays.asList(beginWord));
            BQ.add(Arrays.asList(endWord));
            fmemo.put(beginWord, 0);
            bmemo.put(endWord, 0);

            int dist = 0;
            while (!FQ.isEmpty() && !BQ.isEmpty()) {
                dist++;
                nextStep(FQ, fmemo, words, dist);
                if (meet(FQ, BQ)) return genAllPath(FQ, BQ);
                nextStep(BQ, bmemo, words, dist);
                if (meet(FQ, BQ)) return genAllPath(FQ, BQ);
            }
            return new LinkedList<>();
        }

        private void nextStep(Queue<List<String>> Q, Map<String, Integer> memo, Set<String> words, int dist) {
            int size = Q.size();
            while (size-- > 0) {
                List<String> path = Q.poll();
                String word = path.get(path.size() - 1);
                for (int i = 0; i < word.length(); i++) {
                    char[] ss = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        ss[i] = c;
                        String next = new String(ss);
                        if (word.equals(next) || !words.contains(next)) continue;
                        if (memo.containsKey(next) && memo.get(next) < dist) continue;

                        List<String> newPath = new LinkedList<>(path);
                        newPath.add(next);
                        Q.add(newPath);
                        memo.put(next, dist);
                    }
                }
            }
        }

        private List<List<String>> genAllPath(Queue<List<String>> FQ, Queue<List<String>> BQ) {
            List<List<String>> result = new LinkedList<>();
            for (List<String> fpath : FQ) {
                for (List<String> bpath : BQ) {
                    if (!fpath.get(fpath.size() - 1).equals(bpath.get(bpath.size() - 1))) continue;
                    List<String> tmp = new LinkedList<>(bpath);
                    Collections.reverse(tmp);
                    List<String> fullPath = new LinkedList<>(fpath);
                    fullPath.remove(fullPath.size() - 1);
                    fullPath.addAll(tmp);
                    result.add(fullPath);
                }
            }
            return result;
        }

        private boolean meet(Queue<List<String>> FQ, Queue<List<String>> BQ) {
            for (List<String> fpath : FQ) {
                for (List<String> bpath : BQ) {
                    if (fpath.get(fpath.size() - 1).equals(bpath.get(bpath.size() - 1))) return true;
                }
            }
            return false;
        }

    }

}
