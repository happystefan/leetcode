package bfs_dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q030_Substring_with_Concatenation_of_All_Words {

    // Time Limit Exceeded
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        if (words.length == 0) {
            return result;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(i);
        }
        for (int i = 0; i < s.length(); i++) {
            if (dfs(s, i, set, words)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(String s, int pos, Set<Integer> set, String[] words) {
        if (pos <= s.length() && set.size() == 0) {
            return true;
        }
        for (int i : set) {
            if (s.substring(pos, pos + words[0].length()).equals(words[i])) {
                Set<Integer> new_set = new HashSet<>(set);
                new_set.remove(i);
                if (dfs(s, pos + words[i].length(), new_set, words)) {
                    return true;
                }
            }
        }
        return false;
    }

}
