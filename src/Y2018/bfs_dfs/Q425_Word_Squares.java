package Y2018.bfs_dfs;

import java.util.LinkedList;
import java.util.List;

public class Q425_Word_Squares {

    // DFS + prune : Time Limit Exceeded
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new LinkedList<>();
        dfs(result, words, new LinkedList<>());
        return result;
    }

    private boolean isSquare(List<String> list, int n) {
        if (n == -1 || n == 0) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (list.get(n).charAt(i) != list.get(i).charAt(n)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<String>> result, String[] words, List<String> list) {
        if (!isSquare(list, list.size() - 1)) {
            return;
        }
        if (list.size() == words[0].length()) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < words.length; i++) {
            list.add(words[i]);
            dfs(result, words, list);
            list.remove(list.size() - 1);
        }
    }

}
