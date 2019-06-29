package facebook.dp;

import java.util.*;

public class Q140_Word_Break_II {

    Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        memo.put("", Arrays.asList(""));
        return dfs(s, set);
    }

    private List<String> dfs(String target, Set<String> set) {
        if (memo.containsKey(target)) return memo.get(target);
        List<String> result = new LinkedList<>();
        for (int i = 0; i <= target.length(); i++) {
            String word = target.substring(0, i);
            if (!set.contains(word)) continue;
            List<String> tail = dfs(target.substring(i), set);
            for (String str : tail) {
                result.add(word + (str.equals("") ? "" : " ") + str);
            }
        }
        memo.put(target, result);
        return result;
    }

}
