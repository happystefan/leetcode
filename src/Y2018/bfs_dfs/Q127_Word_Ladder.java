package Y2018.bfs_dfs;

import java.util.*;

public class Q127_Word_Ladder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 0;
        }
        wordList.add(beginWord);
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String a = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String b = wordList.get(j);
                if (isNeighbor(a, b)) {
                    map.computeIfAbsent(a, k -> new HashSet<>());
                    map.computeIfAbsent(b, k -> new HashSet<>());
                    map.get(a).add(b);
                    map.get(b).add(a);
                }
            }
        }
        Queue<String> Q = new LinkedList<>();
        Q.offer(beginWord);
        Set<String> visited = new HashSet<>();
        int result = 1;
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                String curr = Q.poll();
                if (curr.equals(endWord)) {
                    return result;
                }
                visited.add(curr);
                if (!map.containsKey(curr)) {
                    continue;
                }
                for (String next : map.get(curr)) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    Q.offer(next);
                }
            }
            result++;
        }
        return 0;
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
