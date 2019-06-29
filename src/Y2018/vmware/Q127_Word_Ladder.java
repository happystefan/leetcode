package Y2018.vmware;

import java.util.*;

public class Q127_Word_Ladder {

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
