package Y2018.linkedin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q267_Palindrome_Permutation_II {

    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<String> result = new LinkedList<>();

        int cnt = 0;
        char seed = '\0';
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) {
                cnt += 1;
                seed = c;
            }
            if (cnt > 1) {
                return result;
            }
        }

        if (seed == '\0') {
            dfs(result, "", map, s.length());
        } else {
            map.put(seed, map.get(seed) - 1);
            dfs(result, "" + seed, map, s.length());
        }
        return result;
    }

    private void dfs(List<String> result, String cur, Map<Character, Integer> map, int length) {
        if (cur.length() == length) {
            result.add(cur);
            return;
        }
        for (char c : map.keySet()) {
            if (map.get(c) == 0) {
                continue;
            }
            map.put(c, map.get(c) - 2);
            dfs(result, c + cur + c, map, length);
            map.put(c, map.get(c) + 2);
        }
    }

}
