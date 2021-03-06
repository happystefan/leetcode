package Y2019.facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q0301_Remove_Invalid_Parentheses {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        public List<String> removeInvalidParentheses(String s) {
            List<String> result = new LinkedList<>();
            dfs(result, s, 0, 0, new char[]{'(', ')'});
            return result;
        }

        private void dfs(List<String> result, String s, int pos_i, int pos_j, char[] pair) {
            int cnt = 0;
            for (int i = pos_i; i < s.length(); i++) {
                if (s.charAt(i) == pair[0]) cnt++;
                if (s.charAt(i) == pair[1]) cnt--;
                if (cnt >= 0) continue;
                for (int j = pos_j; j <= i; j++) {
                    if (s.charAt(j) == pair[1] && (j == pos_j || s.charAt(j - 1) != pair[1])) {
                        dfs(result, s.substring(0, j) + s.substring(j + 1), i, j, pair);
                    }
                }
                return;
            }
            String rs = new StringBuilder(s).reverse().toString();
            if (pair[0] == ')') {
                result.add(rs);
                return;
            }
            dfs(result, rs, 0, 0, new char[]{')', '('});
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {

        public List<String> removeInvalidParentheses(String s) {
            List<String> result = new LinkedList<>();
            dfs(result, s, 0, 0, new char[]{'(', ')'});
            return result;
        }

        private void dfs(List<String> result, String s, int pos_i, int pos_j, char[] pair) {
            int cnt = 0;
            int i = pos_i;
            while (i < s.length() && cnt >= 0) {
                if (s.charAt(i) == pair[0]) cnt++;
                if (s.charAt(i) == pair[1]) cnt--;
                i++;
            }
            if (cnt >= 0) {
                // no extra ')' is detected. We now have to detect extra '(' by reversing the string.
                String rs = new StringBuilder(s).reverse().toString();
                if (pair[0] == '(') dfs(result, rs, 0, 0, new char[]{')', '('});
                else result.add(rs);
            } else {
                // extra ')' is detected and we have to remove it
                i -= 1;
                for (int j = pos_j; j <= i; j++) {
                    if (s.charAt(j) == pair[1] && (j == pos_j || s.charAt(j - 1) != pair[1])) {
                        dfs(result, s.substring(0, j) + s.substring(j + 1), i, j, pair);
                    }
                }
            }
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 3
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution3 {

        public List<String> removeInvalidParentheses(String s) {
            int l = 0, r = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') l++;
                if (c == ')') {
                    if (l > 0) l--;
                    else r++;
                }
            }
            Set<String> result = new HashSet<>();
            dfs(result, s.toCharArray(), "", s.length() - l - r, 0, 0, 0);
            return new LinkedList<>(result);
        }

        private void dfs(Set<String> result, char[] ss, String str, int len, int l, int r, int pos) {
            if (str.length() == len && l == r) {
                result.add(str);
                return;
            }
            for (int i = pos; i < ss.length; i++) {
                if (ss[i] == '(') dfs(result, ss, str + ss[i], len, l + 1, r, i + 1);
                else if (ss[i] == ')') {
                    if (l > r) dfs(result, ss, str + ss[i], len, l, r + 1, i + 1);
                } else dfs(result, ss, str + ss[i], len, l, r, i + 1);
            }
        }

    }

}
