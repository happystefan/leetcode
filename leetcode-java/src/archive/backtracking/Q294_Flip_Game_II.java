package archive.backtracking;

import java.util.*;

public class Q294_Flip_Game_II {

    Map<String, Boolean> map = new HashMap<>();
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        return dfs(s);
    }

    private boolean dfs(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        boolean result = false;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i)+"--"+s.substring(i+2);
                if (!dfs(t)) {
                    result = true;
                }
            }
        }
        map.put(s, result);
        return result;
    }

}
