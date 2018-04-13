package facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q120_Word_Ladder {

    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 1;
        }

        dict.add(start);
        dict.add(end);

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int result = 1;
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                Set<String> nextWords = getNextWords(word, dict);
                for (String nextWord : nextWords) {
                    if (nextWord.equals(end)) {
                        return result;
                    }
                    if (visited.contains(nextWord)) {
                        continue;
                    }
                    queue.offer(nextWord);
                    visited.add(nextWord);
                }
            }
        }
        return 0;
    }

    private Set<String> getNextWords(String word, Set<String> dict) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                char[] chars = word.toCharArray();
                chars[i] = c;
                String nextWord = new String(chars);
                if (!dict.contains(nextWord)) {
                    continue;
                }
                result.add(nextWord);
            }
        }
        return result;
    }

}
