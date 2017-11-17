import java.util.*;

public class Q139_Word_Break_B {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] canReach  = new boolean[s.length()+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (!canReach[start]) {
                canReach[start] = true;
                for (int j = start+1; j <= s.length(); j++) {
                    String nword = s.substring(start, j);
                    if (wordSet.contains(nword)) {
                        queue.add(j);
                        if (j == s.length()) return true;
                    }
                }
            }
        }
        return false;
    }

}