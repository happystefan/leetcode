package archive.bfs_dfs;

import java.util.*;

public class Q425_Word_Squares_B {

    // DFS + HashMap for prefix->word  look-up
    public List<List<String>> wordSquares(String[] words) {
        int len = words[0].length();
        Map<String, List<String>> map = new HashMap<>();
        // build prefix->word look-up
        for (String word : words) {
            for (int j = 0; j < len; j++) {
                String prefix = word.substring(0, j);
                map.computeIfAbsent(prefix, k -> new LinkedList<>());
                map.get(prefix).add(word);
            }
        }
        List<List<String>> result = new LinkedList<>();
        dfs(result, map, words, new LinkedList<>());
        return result;
    }

    private void dfs(List<List<String>> result, Map<String, List<String>> map, String[] words, List<String> list) {
        if (list.size() == words[0].length()) {
            result.add(new LinkedList<>(list));
            return;
        }
        String prefix = "";
        int n = list.size();
        for (int i = 0; i < n; i++) {
            prefix += list.get(i).charAt(n);
        }
        if (!map.containsKey(prefix)) {
            return;
        }
        for (String word : map.get(prefix)) {
            list.add(word);
            dfs(result, map, words, list);
            list.remove(list.size()-1);
        }
    }

}
