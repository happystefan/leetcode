package Y2020.facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q0301_Remove_Invalid_Parentheses {

    Set<String> visited = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        char[] ss = s.toCharArray();
        int l = 0, r = 0;
        for (char c : ss) {
            if (c == '(') l++;
            else if (c == ')') {
                if (l > 0) l--;
                else r++;
            }
        }
        Set<String> set = new HashSet<>();
        dfs(set, "", ss, 0, ss.length - l - r, 0, 0);
        return new LinkedList<>(set);
    }

    private void dfs(Set<String> rslt, String str, char[] ss, int pos, int n, int l, int r) {
        if (str.length() == n && l == r) {
            rslt.add(str);
            return;
        }
        if (visited.contains(str)) return;
        for (int i = pos; i < ss.length; i++) {
            if (ss[i] != '(' && ss[i] != ')') dfs(rslt, str + ss[i], ss, i + 1, n, l, r);
            else {
                if (ss[i] == ')' && l > r) dfs(rslt, str + ')', ss, i + 1, n, l, r + 1);
                else if (ss[i] == '(') {
                    dfs(rslt, str + '(', ss, i + 1, n, l + 1, r);
                }
            }
        }
        visited.add(str);
    }

}
