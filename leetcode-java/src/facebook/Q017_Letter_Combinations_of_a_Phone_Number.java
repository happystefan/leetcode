package facebook;

import java.util.*;

public class Q017_Letter_Combinations_of_a_Phone_Number {

    public List<String> letterCombinations(String digits) {
        String[] table = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) return result;
        dfs(result, "", digits, 0, table);
        return result;
    }

    private void dfs(List<String> result, String str, String digits, int pos, String[] table) {
        if (pos == digits.length()) {
            result.add(str);
            return;
        }
        for (char c : table[digits.charAt(pos)-'0'].toCharArray()) {
            dfs(result, str+c, digits, pos+1, table);
        }
    }

}
