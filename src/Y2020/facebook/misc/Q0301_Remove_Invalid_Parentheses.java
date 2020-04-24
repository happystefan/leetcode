package Y2020.facebook.misc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q0301_Remove_Invalid_Parentheses {

    class solution {

        public List<String> removeInvalidParentheses(String s) {
            List<String> rslt = new LinkedList<>();
            remove(rslt, s, 0, 0, '(', ')');
            return rslt;
        }

        private void remove(List<String> rslt, String s, int ii, int jj, char l, char r) {
            int cnt = 0;
            int i;
            for (i = ii; i < s.length(); i++) {
                if (s.charAt(i) == l) cnt++;
                else if (s.charAt(i) == r) cnt--;
                if (cnt < 0) break;
            }
            if (cnt >= 0) { // no extra '(' found
                String rs = new StringBuilder(s).reverse().toString();
                if (l == '(') remove(rslt, rs, 0, 0, ')', '(');
                else rslt.add(rs);
            } else {
                // 'i' is the index of abnormal ')' which makes count < 0
                for (int j = jj; j <= i; j++) {
                    if (s.charAt(j) == r) remove(rslt, s.substring(0, j) + s.substring(j + 1), i, j, l, r);
                    while (j + 1 <= i && s.charAt(j + 1) == s.charAt(j)) j++;
                }
            }
        }

    }

    class solution_dfs_generate {

        Set<String> visited = new HashSet<>();

        public List<String> removeInvalidParentheses(String s) {
            char[] ss = s.toCharArray();
            int l = 0, r = 0;
            for (char c : ss) {
                if (c == '(') l++;
                else if (c == ')') {
                    if (l != 0) l--;
                    else r++;
                }
            }
            Set<String> rslt = new HashSet<>();
            dfs(rslt, ss, "", 0, 0, ss.length - l - r, 0);
            return new LinkedList<>(rslt);
        }

        private void dfs(Set<String> rslt, char[] ss, String str, int l, int r, int len, int pos) {
            if (str.length() == len && l == r) {
                rslt.add(str);
                return;
            }
            if (visited.contains(str)) return;
            for (int i = pos; i < ss.length; i++) {
                if (ss[i] != '(' && ss[i] != ')') {
                    dfs(rslt, ss, str + ss[i], l, r, len, i + 1);
                    continue;
                }
                if (l >= r && ss[i] == '(') dfs(rslt, ss, str + ss[i], l + 1, r, len, i + 1);
                if (l > r && ss[i] == ')') dfs(rslt, ss, str + ss[i], l, r + 1, len, i + 1);
            }
            visited.add(str);
        }

    }

}
