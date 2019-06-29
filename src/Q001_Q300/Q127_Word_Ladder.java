package Q001_Q300;

import java.util.*;

public class Q127_Word_Ladder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordset = new HashSet<>(wordList);
        if (!wordset.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        queue.add(null);

        Set<String> visited = new HashSet<>();
        int dis = 1;

        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s != null) {
                for (int i = 0; i < s.length(); i++) {
                    char[] ss = s.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        ss[i] = c;
                        String ns = new String(ss);
                        if (wordset.contains(ns) && ns.equals(endWord)) return dis + 1;
                        if (wordset.contains(ns) && !visited.contains(ns)) {
                            queue.add(ns);
                            visited.add(ns);
                        }
                    }
                }
            } else {
                dis++;
                if (!queue.isEmpty()) queue.add(null);
            }
        }
        return 0;
    }

}