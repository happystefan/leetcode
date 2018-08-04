package backtracking;

import java.util.*;

public class Q022_Generate_Parentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        dfs(result, "", 0, 0, n*2);
        return result;
    }

    private void dfs(List<String> result, String str, int l, int r, int n) {
        if (l+r == n) {
            if (l == r) {
                result.add(str);
            }
            return;
        }
        if (l == r) {
            dfs(result, str+"(", l+1, r, n);
        } else {
            dfs(result, str+"(", l+1, r, n);
            dfs(result, str+")", l, r+1, n);
        }
    }

}
