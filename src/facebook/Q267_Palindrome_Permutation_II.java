package facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q267_Palindrome_Permutation_II {

    public List<String> generatePalindromes(String s) {
        List<String> result = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        Character seed = null;
        int cnt = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) {
                seed = c;
                cnt++;
            }
            if (cnt > 1) return result;
        }
        if (seed != null) {
            map.put(seed, map.get(seed) - 1);
            if (map.get(seed) == 0) map.remove(seed);
        }
        dfs(result, seed == null ? "" : "" + seed, map);
        return result;
    }

    private void dfs(List<String> result, String str, Map<Character, Integer> map) {
        if (map.isEmpty()) {
            result.add(str);
            return;
        }
        for (char c : map.keySet()) {
            Map<Character, Integer> tmp = new HashMap<>(map);
            tmp.put(c, tmp.get(c) - 2);
            if (tmp.get(c) == 0) tmp.remove(c);
            dfs(result, c + str + c, tmp);
        }
    }

}
