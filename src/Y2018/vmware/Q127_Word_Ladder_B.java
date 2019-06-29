package Y2018.vmware;

import java.util.*;

public class Q127_Word_Ladder_B {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
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

}
