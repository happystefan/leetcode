package facebook;

import java.util.*;

public class Q017_Letter_Combinations_of_a_Phone_Number {

    public List<String> letterCombinations(String digits) {
        Map<Integer, Set<Character>> map = new HashMap<>();
        map.put(0, new HashSet<>());
        map.put(1, new HashSet<>());
        map.put(2, new HashSet<>(Arrays.asList('a', 'b', 'c')));
        map.put(3, new HashSet<>(Arrays.asList('d', 'e', 'f')));
        map.put(4, new HashSet<>(Arrays.asList('g', 'h', 'i')));
        map.put(5, new HashSet<>(Arrays.asList('j', 'k', 'l')));
        map.put(6, new HashSet<>(Arrays.asList('m', 'n', 'o')));
        map.put(7, new HashSet<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put(8, new HashSet<>(Arrays.asList('t', 'u', 'v')));
        map.put(9, new HashSet<>(Arrays.asList('w', 'x', 'y', 'z')));
        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        dfs(result, map, digits, "", 0);
        return result;
    }

    private void dfs(List<String> result, Map<Integer, Set<Character>> map, String digits, String str, int pos) {
        if (pos == digits.length()) {
            result.add(str);
            return;
        }
        for (char c : map.get(digits.charAt(pos) - '0')) {
            dfs(result, map, digits, str + c, pos + 1);
        }
    }

}
