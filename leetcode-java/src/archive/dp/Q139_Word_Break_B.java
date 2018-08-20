package archive.dp;

import java.util.*;

public class Q139_Word_Break_B {

    Map<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
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
