package Y2019.Q0001_Q0300;

import java.util.*;

public class Q0139_Word_Break {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: dfs (Time Limit Exceeded)
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        public boolean wordBreak(String s, List<String> wordDict) {
            for (String word : wordDict) {
                if (s.equals(word) || s.startsWith(word) && wordBreak(s.substring(word.length()), wordDict))
                    return true;
            }
            return false;
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: dfs with memory
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {

        Map<String, Boolean> memo = new HashMap<>();

        public boolean wordBreak(String s, List<String> wordDict) {
            if (memo.containsKey(s)) return memo.get(s);
            for (String word : wordDict) {
                if (s.equals(word) || s.startsWith(word) && wordBreak(s.substring(word.length()), wordDict)) {
                    memo.put(s, true);
                    return true;
                }
            }
            memo.put(s, false);
            return false;
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 3: dp
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution3 {

        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] |= dp[j] && set.contains(s.substring(j, i));
                }
            }
            return dp[s.length()];
        }

    }


    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 4: bfs
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution4 {

        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] canReach = new boolean[s.length() + 1];
            Queue<Integer> Q = new LinkedList<>();
            Q.add(0);
            while (!Q.isEmpty()) {
                int i = Q.poll();
                if (i == s.length()) return true;
                if (canReach[i]) continue;
                canReach[i] = true;
                for (String word : wordDict) {
                    if (s.substring(i).startsWith(word)) {
                        Q.add(i + word.length());
                    }
                }
            }
            return false;
        }

    }

}
