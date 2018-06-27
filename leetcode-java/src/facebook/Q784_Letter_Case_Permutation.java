package facebook;

import java.util.*;

public class Q784_Letter_Case_Permutation {

    public List<String> letterCasePermutation(String S) {
        List<String> result = new LinkedList<>();
        if (S == null || S.length() == 0) {
            result.add("");
            return result;
        }
        char[] ss = S.toCharArray();
        dfs(result, ss, 0);
        return result;
    }

    private void dfs(List<String>result, char[] ss, int i) {
        if (i == ss.length) {
            result.add(new String(ss));
            return;
        }
        if (Character.isDigit(ss[i])) {
            dfs(result, ss, i+1);
            return;
        }
        char[] next_ss = new char[ss.length];
        System.arraycopy(ss, 0, next_ss, 0, ss.length);
        if (ss[i] >= 'a' && ss[i] <= 'z') {
            next_ss[i] = Character.toUpperCase(ss[i]);
        }
        if (ss[i] >= 'A' && ss[i] <= 'Z') {
            next_ss[i] = Character.toLowerCase(ss[i]);
        }
        dfs(result, ss, i+1);
        dfs(result, next_ss, i+1);
    }

}
