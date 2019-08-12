package Y2019.Q0001_Q0300;

import java.util.*;

public class Q0140_Word_Break_II {

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
