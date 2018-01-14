package google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q451_Sort_Characters_By_Frequency_B {

    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) count.put(c, count.getOrDefault(c, 0)+1);

        List<Character>[] bucket = new List[s.length()+1];
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            char c = entry.getKey();
            int t = entry.getValue();
            if (bucket[t] == null) bucket[t] = new LinkedList<>();
            bucket[t].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length-1; i >= 0; i--) {
            if (bucket[i] == null) continue;
            for (char c : bucket[i]) {
                int t = i;
                while (t-- > 0) sb.append(c);
            }
        }
        return sb.toString();
    }

}
