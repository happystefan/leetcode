package google;

import java.util.LinkedList;
import java.util.List;

public class Q017_Letter_Combinations_of_a_Phone_Number {

    public List<String> letterCombinations(String digits) {
        String[] table = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new LinkedList<>();
        dfs(digits, "", table, ans);
        return ans;
    }

    private void dfs(String digits, String cur, String[] table, List<String> ans) {
        if (digits.length() == 0) {
            return;
        }
        for (char c : table[digits.charAt(0)-'0'].toCharArray()) {
            if (digits.length() == 1) ans.add(cur+c);
            dfs(digits.substring(1), cur+c, table, ans);
        }
    }

}
