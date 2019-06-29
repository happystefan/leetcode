package Y2018.dp;

import java.util.*;

public class Q472_Concatenated_Words_B {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        List<String> result = new LinkedList<>();
        for (String word : words) {
            if (dfs(set, word)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean dfs(Set<String> set, String word) {
        for (int i = 1; i < word.length(); i++) {
            String lpart = word.substring(0, i);
            String rpart = word.substring(i);
            if (set.contains(lpart) && (set.contains(rpart) || dfs(set, rpart))) {
                return true;
            }
        }
        return false;
    }

}
