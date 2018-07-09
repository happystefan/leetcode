package bfs_dfs;

import java.util.*;

public class Q756_Pyramid_Transition_Matrix {

    Map<String, Set<Character>> map = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String str : allowed) {
            String ab = str.substring(0, 2);
            char c = str.charAt(2);
            map.computeIfAbsent(ab, k -> new HashSet<>());
            map.get(ab).add(c);
        }
        return dfs(bottom);
    }

    private boolean dfs(String bottom) {
        if (bottom.length() == 2) {
            return map.containsKey(bottom);
        }
        Set<String> set = new HashSet<>();
        set.add("");
        for (int i = 0; i < bottom.length()-1; i += 1) {
            String ab = bottom.substring(i, i+2);
            Set<String> tmp = new HashSet<>();
            if (!map.containsKey(ab)) {
                return false;
            }
            for (char c: map.get(ab)) {
                for (String str : set) {
                    tmp.add(str+c);
                }
            }
            set = tmp;
        }
        for (String str : set) {
            if (dfs(str)) {
                return true;
            }
        }
        return false;
    }

}
