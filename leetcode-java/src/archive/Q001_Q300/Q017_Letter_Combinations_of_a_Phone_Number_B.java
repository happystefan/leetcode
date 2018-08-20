package archive.Q001_Q300;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mqliang on 5/30/17.
 */
public class Q017_Letter_Combinations_of_a_Phone_Number_B {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return null;
        }

        String[] letters = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new LinkedList<>();
        ans.add("");
        for (char d : digits.toCharArray()) {
            String cs = letters[d-'0'];
            List<String> tmp = new LinkedList<>();
            for (char c : cs.toCharArray()) {
                for (String s : ans) {
                    tmp.add(s+c);
                }
            }
            ans = tmp;
        }
        return ans;
    }
}
