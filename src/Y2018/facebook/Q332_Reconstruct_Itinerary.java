package Y2018.facebook;

import java.util.*;

public class Q332_Reconstruct_Itinerary {

    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] pair : tickets) {
            map.computeIfAbsent(pair[0], k -> new PriorityQueue<>());
            map.get(pair[0]).add(pair[1]);
        }
        List<String> result = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            String u = stack.peek();
            if (map.get(u) == null || map.get(u).isEmpty()) {
                result.add(0, u);
                stack.pop();
            } else {
                stack.push(map.get(u).poll());
            }
        }
        return result;
    }

}
