package bfs_dfs;


import java.util.*;

public class Q126_Word_Ladder_II {

    // Time Limit Exceeded
    private Map<String, Integer> map = new HashMap<>(); // word to index map

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return new LinkedList<>();
        }
        wordList = new ArrayList<>(wordList);
        wordList.add(beginWord);
        for (String word : wordList) {
            map.put(word, map.size());
        }

        int n = wordList.size();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
            String a = wordList.get(i);
            for (int j = i + 1; j < n; j++) {
                String b = wordList.get(j);
                if (isNeighbor(a, b)) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        graph[j][i] = graph[i][j];
                    }
                }
            }
        }
        int beg_idx = map.get(beginWord);
        int end_idx = map.get(endWord);
        if (graph[beg_idx][end_idx] == Integer.MAX_VALUE) {
            return new LinkedList<>();
        }
        return new LinkedList<>(dfs(graph, wordList, beg_idx, end_idx));
    }

    private Set<List<String>> dfs(int[][] graph, List<String> wordList, int s, int e) {
        Set<List<String>> result = new HashSet<>();
        if (s == e) {
            return result;
        }
        if (graph[s][e] == 1) {
            result.add(Arrays.asList(wordList.get(s), wordList.get(e)));
            return result;
        }
        int n = graph.length;
        for (int k = 0; k < n; k++) {
            if (s == k || e == k) {
                continue;
            }
            if (graph[s][e] == graph[s][k] + graph[k][e]) {
                Set<List<String>> ls = dfs(graph, wordList, s, k);
                Set<List<String>> rs = dfs(graph, wordList, k, e);
                for (List<String> l : ls) {
                    for (List<String> r : rs) {
                        List<String> path = new LinkedList<>();
                        path.addAll(l);
                        for (int i = 1; i < r.size(); i++) {
                            path.add(r.get(i));
                        }
                        result.add(path);
                    }
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

}
