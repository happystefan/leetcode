package facebook;

import java.util.*;

public class Q425_Letter_Combinations_of_a_Phone_Number {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> dict = new HashMap<>();
        dict.put('2', Arrays.asList('a', 'b', 'c'));
        dict.put('3', Arrays.asList('d', 'e', 'f'));
        dict.put('4', Arrays.asList('g', 'h', 'i'));
        dict.put('5', Arrays.asList('j', 'k', 'l'));
        dict.put('6', Arrays.asList('m', 'n', 'o'));
        dict.put('7', Arrays.asList('p', 'q', 'r', 's'));
        dict.put('8', Arrays.asList('t', 'u', 'v'));
        dict.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        dfs(result, "", digits, 0, dict);
        return result;
    }

    private void dfs(List<String> result, String str, String digits, int pos, Map<Character, List<Character>> dict) {
        if (pos == digits.length()) {
            result.add(str);
            return;
        }
        for (char c : dict.get(digits.charAt(pos))) {
            dfs(result, str+c, digits, pos+1, dict);
        }
    }

}
