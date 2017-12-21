package google;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q427_Generate_Parentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        dfs(ans, "", n, n);
        return ans;
    }

    public void dfs(List<String> ans, String s, int l, int r) {
        if (l == 0 && r == 0) {
            ans.add(s);
            return;
        }
        if (l >= 0) dfs(ans, s+"(",  l-1, r);
        if (r >= 0 && l < r) dfs(ans, s+")", l, r-1);
    }

}
