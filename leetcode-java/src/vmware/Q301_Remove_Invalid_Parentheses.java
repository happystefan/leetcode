package vmware;

import java.util.*;

public class Q301_Remove_Invalid_Parentheses {

    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')'){
                if (l > 0) l--;
                else r++;
            }
        }
        Set<String> set = new HashSet<>();
        dfs(set, "", s.toCharArray(), s.length()-l-r, 0, 0, 0);
        return new LinkedList<>(set);
    }

    private void dfs(Set<String> set, String str, char[] ss, int len, int l, int r, int pos) {
        if (str.length() == len && l == r) {
            set.add(str);
            return;
        }
        for (int i = pos; i < ss.length; i++) {
            if (ss[i] == '(' && l >= r) dfs(set, str+ss[i], ss, len, l+1, r, i+1);
            else if (ss[i] == ')' && l > r) dfs(set, str+ss[i], ss, len, l, r+1, i+1);
            else dfs(set, str+ss[i], ss, len, l, r, i+1);
        }
    }

}
