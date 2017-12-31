package google;

import java.util.*;

public class Q140_Word_Break_II {

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private List<String> dfs(String s, Set<String> wordSet, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        List<String> ans = new LinkedList<>();
        if (s.length() == 0) {
            ans.add("");
            return ans;
        }
        for (String word : wordSet) {
            if (s.startsWith(word)) {
                List<String> subList = dfs(s.substring(word.length()), wordSet, map);
                for (String sub : subList) {
                    ans.add(word+(sub.equals("") ? "" : " ")+sub);
                }
            }
        }
        map.put(s, ans);
        return ans;
    }

}
