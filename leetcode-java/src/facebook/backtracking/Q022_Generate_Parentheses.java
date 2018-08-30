package facebook.backtracking;

import java.util.*;

public class Q022_Generate_Parentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        dfs(result, "", n, n);
        return result;
    }

    private void dfs(List<String> result, String str, int l, int r) {
        if (l < 0 || r < 0) return;
        if (l == 0 && r == 0) {
            result.add(str);
            return;
        }
        if (l == r) {
            dfs(result, str+'(', l-1, r);
        } else {
            dfs(result, str+'(', l-1, r);
            dfs(result, str+')', l, r-1);
        }
    }

}
