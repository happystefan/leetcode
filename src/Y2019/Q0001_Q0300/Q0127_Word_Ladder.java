package Y2019.Q0001_Q0300;

import java.util.*;

public class Q0127_Word_Ladder {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: bfs
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            wordList.add(beginWord);
            if (!wordList.contains(endWord)) return 0;
            Map<String, Set<String>> map = new HashMap<>();
            for (int i = 0; i < wordList.size(); i++) {
                for (int j = i + 1; j < wordList.size(); j++) {
                    String a = wordList.get(i);
                    String b = wordList.get(j);
                    if (!isNeighbor(a, b)) continue;
                    map.computeIfAbsent(a, k -> new HashSet<>());
                    map.computeIfAbsent(b, k -> new HashSet<>());
                    map.get(a).add(b);
                    map.get(b).add(a);
                }
            }
            Queue<String> Q = new LinkedList<>();
            Q.add(beginWord);
            Set<String> seen = new HashSet<>();
            int result = 0;
            while (!Q.isEmpty()) {
                result++;
                int size = Q.size();
                while (size-- > 0) {
                    String word = Q.poll();
                    if (word.equals(endWord)) return result;
                    seen.add(word);
                    for (String next : map.getOrDefault(word, new HashSet<>())) {
                        if (seen.contains(next)) continue;
                        Q.add(next);
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

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: build graph ad-hoc
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            wordList.add(beginWord);
            Set<String> words = new HashSet<>(wordList);
            Queue<String> Q = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            int result = 0;
            Q.add(beginWord);
            visited.add(beginWord);
            while (!Q.isEmpty()) {
                result++;
                int size = Q.size();
                while (size-- > 0) {
                    String word = Q.poll();
                    if (word.equals(endWord)) return result;
                    for (int i = 0; i < word.length(); i++) {
                        char[] ss = word.toCharArray();
                        for (char c = 'a'; c <= 'z'; c++) {
                            ss[i] = c;
                            String next = new String(ss);
                            if (word.equals(next) || !words.contains(next)) continue;
                            if (visited.contains(next)) continue;
                            Q.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
            return 0;
        }

    }

}
