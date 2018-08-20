package archive.google;

import java.util.*;

public class Q139_Word_Break {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        boolean[] canReach  = new boolean[s.length()+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (i == s.length()) return true;
            if (canReach[i]) continue;
            canReach[i] = true;
            for (int j = i+1; j <= s.length(); j++) {
                if (set.contains(s.substring(i,j))) queue.add(j);
            }
        }
        return false;
    }

}
