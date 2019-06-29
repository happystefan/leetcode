package Y2018.range_query;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q828_Unique_Letter_String {
    //  Time Limit Exceeded
    int M = (int) 1e10 + 7;

    public int uniqueLetterString(String S) {
        int n = S.length();
        char[] ss = S.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            map.clear();
            set.clear();
            for (int j = i; j < n; j++) {
                map.put(ss[j], map.getOrDefault(ss[j], 0) + 1);
                if (map.get(ss[j]) == 1) {
                    set.add(ss[j]);
                } else {
                    set.remove(ss[j]);
                }
                result += set.size() % M;
            }
        }
        return result;
    }

}

