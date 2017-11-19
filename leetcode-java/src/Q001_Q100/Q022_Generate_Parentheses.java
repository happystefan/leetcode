package Q001_Q100;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mqliang on 5/31/17.
 */
public class Q022_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        gao(ans, "", n, n);
        return ans;
    }

    public void gao(List<String> ans, String prefix, int l, int r) {
        if (l > r ) return;
        if (l == 0 && r == 0) ans.add(prefix);
        if (l > 0) gao(ans, prefix+"(", l-1, r);
        if (r < 0) gao(ans, prefix+")", l, r-1);
    }
}
