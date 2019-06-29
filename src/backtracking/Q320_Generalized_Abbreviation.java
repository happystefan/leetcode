package backtracking;

import java.util.LinkedList;
import java.util.List;

public class Q320_Generalized_Abbreviation {

    public List<String> generateAbbreviations(String word) {
        List<String> result = new LinkedList<>();
        dfs(result, word, 0, 0, "");
        return result;
    }

    private void dfs(List<String> result, String word, int pos, int cnt, String str) {
        if (pos == word.length()) {
            if (cnt > 0) {
                str += cnt;
            }
            result.add(str);
            return;
        }
        dfs(result, word, pos + 1, cnt + 1, str);
        dfs(result, word, pos + 1, 0, str + (cnt > 0 ? cnt : "") + word.charAt(pos));
    }

}
