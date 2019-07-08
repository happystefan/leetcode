package Y2019.Q0001_Q0300;

import java.util.LinkedList;
import java.util.List;

public class Q0022_Generate_Parentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        dfs(result, n, n, "");
        return result;
    }

    private void dfs(List<String> result, int l, int r, String str) {
        System.out.printf("%d %d\n", l, r);
        if (l == 0 && r == 0) {
            result.add(str);
            return;
        }
        if (l > 0) dfs(result, l - 1, r, str + "(");
        if (r > l) dfs(result, l, r - 1, str + ")");
    }
}

