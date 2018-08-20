package archive.bfs_dfs;

public class Q439_Ternary_Expression_Parser {

    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }
        return String.valueOf(dfs(expression, 0, expression.length()-1));
    }

    private char dfs(String str, int l, int r) {
        if (l == r) {
            return str.charAt(l);
        }
        int i = 0, cnt = 0;
        for (i = l+1; i < r; i++) {
            if (str.charAt(i) == '?') {
                cnt++;
            }
            if (str.charAt(i) == ':') {
                cnt--;
            }
            if (cnt == 0) {
                break;
            }
        }
        return str.charAt(l) == 'T' ? dfs(str, l+2, i-1) : dfs(str, i+1, r);
    }

}
