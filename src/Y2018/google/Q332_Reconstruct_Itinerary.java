package Y2018.google;

import java.util.*;

public class Q332_Reconstruct_Itinerary {

    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] pair : tickets) {
            map.computeIfAbsent(pair[0], a -> new PriorityQueue<>()).add(pair[1]);
        }
        List<String> ans = new LinkedList<>();
        dfs("JFK", map, ans);
        return ans;
    }

    private void dfs(String s, Map<String, PriorityQueue<String>> map, List<String> ans) {
        while (map.containsKey(s) && !map.get(s).isEmpty()) {
            dfs(map.get(s).poll(), map, ans);
        }
        ans.add(0, s);
    }

}
