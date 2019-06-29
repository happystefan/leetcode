package facebook.dp;

import java.util.*;

public class Q139_Word_Break {

    Map<Integer, Boolean> mamo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return dfs(s, 0, set);
    }

    private boolean dfs(String s, int pos, Set<String> set) {
        if (pos == s.length()) return true;
        if (mamo.containsKey(pos)) return mamo.get(pos);
        boolean result = false;
        for (int i = pos + 1; i <= s.length(); i++) {
            if (set.contains(s.substring(pos, i)) && dfs(s, i, set)) {
                result = true;
                break;
            }
        }
        mamo.put(pos, result);
        return result;
    }

}
