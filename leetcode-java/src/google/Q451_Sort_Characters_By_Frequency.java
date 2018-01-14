package google;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q451_Sort_Characters_By_Frequency {

    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) count.put(c, count.getOrDefault(c, 0)+1);

        PriorityQueue<Map.Entry<Character, Integer>> pqueue = new PriorityQueue<>((a, b) -> b.getValue()-a.getValue());
        pqueue.addAll(count.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pqueue.isEmpty()) {
            char c = pqueue.peek().getKey();
            int t = pqueue.peek().getValue();
            pqueue.poll();
            while (t-- > 0) sb.append(c);
        }
        return sb.toString();
    }

}
