package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0022_Generate_Parentheses {

    public List<String> generateParenthesis(int n) {
        List<String> rslt = new LinkedList<>();
        dfs(rslt, "", 0, 0, n);
        return rslt;
    }

    private void dfs(List<String> rslt, String str, int l, int r, int n) {
        if (l == n && r == n) {
            rslt.add(str);
            return;
        }
        if (l == r) dfs(rslt, str + '(', l + 1, r, n);
        else if (l == n) dfs(rslt, str + ')', l, r + 1, n);
        else {
            dfs(rslt, str + '(', l + 1, r, n);
            dfs(rslt, str + ')', l, r + 1, n);
        }
    }

}
