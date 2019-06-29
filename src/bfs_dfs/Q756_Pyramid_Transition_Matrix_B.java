package bfs_dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q756_Pyramid_Transition_Matrix_B {

    Map<String, List<String>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String str : allowed) {
            String ab = str.substring(0, 2);
            String c = str.substring(2);
            map.computeIfAbsent(ab, k -> new LinkedList<>());
            map.get(ab).add(c);
        }
        return dfs(bottom, 0, "");
    }

    private boolean dfs(String bottom, int pos, String str) {
        if (bottom.length() == 2) {
            return map.containsKey(bottom);
        }
        if (pos == bottom.length() - 1) {
            return dfs(str, 0, ""); // go upper layer
        }
        String ab = bottom.substring(pos, pos + 2);
        if (!map.containsKey(ab)) {
            return false;
        }
        for (String c : map.get(ab)) {
            if (dfs(bottom, pos + 1, str + c)) {
                return true;
            }
        }
        return false;
    }

}
