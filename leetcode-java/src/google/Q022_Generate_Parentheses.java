package google;

import java.util.LinkedList;
import java.util.List;

public class Q022_Generate_Parentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        dfs("", n, n, ans);
        return ans;
    }

    private void dfs(String str, int l, int r, List<String> ans) {
        if (l == 0 && r == 0) {
            ans.add(str);
            return;
        }
        if (l > 0) dfs(str+"(", l-1, r, ans);
        if (r > 0 && r > l) dfs(str+")", l, r-1, ans);
    }

}
