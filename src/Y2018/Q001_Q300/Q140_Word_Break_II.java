package Y2018.Q001_Q300;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q140_Word_Break_II {

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }

    List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);

        List<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = dfs(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }

}
