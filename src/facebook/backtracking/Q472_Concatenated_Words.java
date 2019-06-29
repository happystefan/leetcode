package facebook.backtracking;

import java.util.*;

public class Q472_Concatenated_Words {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        List<String> result = new LinkedList<>();
        for (String word : words) {
            if (dfs(word, set)) result.add(word);
        }
        return result;
    }

    private boolean dfs(String word, Set<String> set) {
        for (int i = 1; i < word.length(); i++) {
            String lpart = word.substring(0, i);
            String rpart = word.substring(i);
            if (set.contains(lpart) && (set.contains(rpart) || dfs(rpart, set))) return true;
        }
        return false;
    }

}
