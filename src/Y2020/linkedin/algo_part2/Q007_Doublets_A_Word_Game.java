package Y2020.linkedin.algo_part2;

import java.util.*;

public class Q007_Doublets_A_Word_Game {


    // pros: only generate edge that BGS traverses, not ALL edges
    public int ladderLength_inflight(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> Q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Q.offer(beginWord);
        visited.add(beginWord);

        int result = 0;
        while (!Q.isEmpty()) {
            result++;
            int size = Q.size();
            while (size-- > 0) {
                String curr = Q.poll();
                for (int i = 0; i < curr.length(); i++) {
                    char[] ss = curr.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        ss[i] = c;
                        String next = new String(ss);
                        if (next.equals(endWord)) return result;
                        if (wordSet.contains(next) && !visited.contains(next)) {
                            Q.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
        }
        return 0;
    }


    // Build the whole graph up front
    // cons: may have too many useless edges in the graph
    // TC: O(M*N^2) + O(V+E), M*N^2 for building graph, O(V+E) is for BFS
    //     M is the length of each word, N is number of words in directory
    // SC: O(M*N^2)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord) || !wordList.contains(endWord)) {
            return 0;
        }
        wordList.add(beginWord);
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String a = wordList.get(i);
                String b = wordList.get(j);
                if (isNeighbor(a, b)) {
                    map.computeIfAbsent(a, k -> new HashSet<>());
                    map.computeIfAbsent(b, k -> new HashSet<>());
                    map.get(a).add(b);
                    map.get(b).add(a);
                }
            }
        }
        int result = 0;
        Queue<String> Q = new LinkedList<>();
        Q.offer(beginWord);
        Set<String> visited = new HashSet<>();
        while (!Q.isEmpty()) {
            result++;
            int size = Q.size();
            while (size-- > 0) {
                String curr = Q.poll();
                if (curr.equals(endWord)) return result;
                visited.add(curr);
                for (String next : map.getOrDefault(curr, new HashSet<>())) {
                    if (!visited.contains(next)) {
                        Q.offer(next);
                    }
                }
            }
        }
        return 0;
    }

    private boolean isNeighbor(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
}
