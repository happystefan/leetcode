package archive.bfs_dfs;

import java.util.*;

public class Q301_Remove_Invalid_Parentheses_B {

    Set<String> visited = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        char[] ss = s.toCharArray();
        int l = 0, r = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '(') {
                l++;
            }
            if (ss[i] == ')') {
                if (l != 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        Set<String> result = new HashSet<>();
        dfs(result, ss, "", 0, 0, ss.length-l-r, 0);
        return new LinkedList<>(result);
    }

    private void dfs(Set<String> result, char[] ss, String str, int l, int r, int len, int pos) {
        if (str.length() == len && l == r) {
            result.add(str);
            return;
        }
        if (visited.contains(str)) {
            return;
        }
        for (int i = pos; i < ss.length; i++) {
            if (ss[i] != '(' && ss[i] != ')') {
                dfs(result, ss, str+ss[i], l, r, len, i+1);
                continue;
            }
            if (l == r && ss[i] == '(') {
                dfs(result, ss, str+"(", l+1, r, len, i+1);
            }
            if (l > r) {
                if (ss[i] == ')') {
                    dfs(result, ss, str+")", l, r+1, len, i+1);
                } else {
                    dfs(result, ss, str+"(", l+1, r, len, i+1);
                }
            }
        }
        visited.add(str);
    }

}