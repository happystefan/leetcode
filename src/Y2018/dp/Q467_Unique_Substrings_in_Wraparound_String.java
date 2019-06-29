package Y2018.dp;

import java.util.HashMap;
import java.util.Map;

public class Q467_Unique_Substrings_in_Wraparound_String {

    public int findSubstringInWraproundString(String p) {
        int n = p.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (j = i; j + 1 < n; j++) {
                if (p.charAt(j + 1) - 'a' != (p.charAt(j) - 'a' + 1) % 26) {
                    break;
                }
            }
            for (int k = i; k <= j; k++) {
                if (!map.containsKey(p.charAt(k)) || map.get(p.charAt(k)) < j - k + 1) {
                    map.put(p.charAt(k), j - k + 1);
                }
            }
            i = j;
        }
        return map.values().stream().mapToInt(Number::intValue).sum();
    }

}
