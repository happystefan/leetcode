package Y2018.Q001_Q300;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mqliang on 5/30/17.
 */
public class Q017_Letter_Combinations_of_a_Phone_Number {
    String[] letters = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return null;
        }

        List<String> ans = new LinkedList<>();
        gao("", digits, ans);
        return ans;
    }

    public void gao(String prifix, String digits, List<String> ans) {
        if (digits == null || digits.length() == 0) {
            ans.add(prifix);
            return;
        }
        for (char c : letters[digits.charAt(0) - '0'].toCharArray()) {
            gao(prifix + c, digits.substring(1), ans);
        }
    }
}
