package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0017_Letter_Combinations_of_a_Phone_Number {

    String[] t = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz",
    };

    class solution1_recursive {

        public List<String> letterCombinations(String digits) {
            List<String> rslt = new LinkedList<>();
            if (digits == null || digits.length() == 0) return rslt;
            dfs(rslt, "", digits, 0);
            return rslt;
        }

        private void dfs(List<String> rslt, String str, String digits, int pos) {
            if (str.length() == digits.length()) {
                rslt.add(str);
                return;
            }
            for (char c : t[digits.charAt(pos) - '0'].toCharArray()) {
                dfs(rslt, str + c, digits, pos + 1);
            }
        }
    }

    class solution1_iterative {

        public List<String> letterCombinations(String digits) {
            List<String> rslt = new LinkedList<>();
            if (digits == null || digits.length() == 0) return rslt;
            rslt.add("");
            for (char digit : digits.toCharArray()) {
                List<String> tmp = new LinkedList<>();
                for (String str : rslt) {
                    for (char c : t[digit - '0'].toCharArray()) {
                        tmp.add(str + c);
                    }
                }
                rslt = tmp;
            }
            return rslt;
        }

    }

}
