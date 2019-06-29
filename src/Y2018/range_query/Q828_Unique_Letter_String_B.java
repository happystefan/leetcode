package Y2018.range_query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q828_Unique_Letter_String_B {

    // Hard to understand
    int M = (int) 1e10 + 7;

    public int uniqueLetterString(String S) {
        Map<Character, List<Integer>> indices = new HashMap();
        for (int i = 0; i < S.length(); ++i) {
            indices.computeIfAbsent(S.charAt(i), k -> new ArrayList<>()).add(i);
        }

        long ans = 0;
        for (List<Integer> index : indices.values()) {
            for (int i = 0; i < index.size(); ++i) {
                long prev = i > 0 ? index.get(i - 1) : -1;
                long next = i < index.size() - 1 ? index.get(i + 1) : S.length();
                ans += (index.get(i) - prev) * (next - index.get(i));
            }
        }
        return (int) ans % M;
    }

}
