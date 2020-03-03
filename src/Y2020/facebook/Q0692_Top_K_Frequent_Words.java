package Y2020.facebook;

import java.util.*;

public class Q0692_Top_K_Frequent_Words {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        PriorityQueue<String> Q = new PriorityQueue<>((a, b) ->
                map.get(a) - map.get(b) == 0 ? b.compareTo(a) : map.get(a) - map.get(b));
        for (String word : map.keySet()) {
            Q.add(word);
            if (Q.size() > k) Q.poll();
        }
        List<String> rslt = new LinkedList<>();
        while (!Q.isEmpty()) rslt.add(0, Q.poll());
        return rslt;
    }

}
