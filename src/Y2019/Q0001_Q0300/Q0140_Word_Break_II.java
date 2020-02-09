package Y2019.Q0001_Q0300;

import java.util.*;

public class Q0140_Word_Break_II {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: dfs with memory
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        Map<String, List<String>> memo = new HashMap<>();

        public List<String> wordBreak(String s, List<String> wordDict) {
            memo.put("", Arrays.asList(""));
            return dfs(s, wordDict);
        }

        private List<String> dfs(String s, List<String> wordDict) {
            if (memo.containsKey(s)) return memo.get(s);
            List<String> result = new LinkedList<>();
            for (String word : wordDict) {
                if (!s.startsWith(word)) continue;
                List<String> list = dfs(s.substring(word.length()), wordDict);
                for (String str : list) {
                    result.add(word + (str.equals("") ? "" : " ") + str);
                }
            }
            memo.put(s, result);
            return result;
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: dp with dfs
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {

        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] |= dp[j] && set.contains(s.substring(j, i));
                }
            }
            List<String> result = new LinkedList<>();
            if (!dp[s.length()]) return result;
            dfs(result, s, dp, set, "", s.length());
            return result;
        }

        private void dfs(List<String> result, String s, boolean[] dp, Set<String> set, String str, int pos) {
            if (pos == 0) {
                result.add(str);
                return;
            }
            for (int i = 0; i < pos; i++) {
                if (dp[i] && set.contains(s.substring(i, pos))) {
                    dfs(result, s, dp, set, s.substring(i, pos) + (str.equals("") ? "" : " " + str), i);
                }
            }
        }

    }

}
