package Y2019.Q0001_Q0300;

import java.util.LinkedList;
import java.util.List;

public class Q0017_Letter_Combinations_of_a_Phone_Number {

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) return result;
        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(result, 0, digits, "", letters);
        return result;
    }

    private void dfs(List<String> result, int i, String digits, String str, String[] letters) {
        if (i == digits.length()) {
            result.add(str);
            return;
        }
        for (char c : letters[digits.charAt(i) - '0'].toCharArray()) {
            dfs(result, i + 1, digits, str + c, letters);
        }
    }

}
