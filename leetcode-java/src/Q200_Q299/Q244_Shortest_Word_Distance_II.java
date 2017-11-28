package Q200_Q299;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q244_Shortest_Word_Distance_II {

    class WordDistance {

        Map<String, LinkedList<Integer>> indice = new HashMap<>();

        public WordDistance(String[] words) {
            for (int i = 0; i < words.length; i++) {
                if (!indice.containsKey(words[i])) {
                    indice.put(words[i], new LinkedList<>());
                }
                LinkedList<Integer> idx = indice.get(words[i]);
                idx.add(i);
                indice.put(words[i], idx);
            }
        }

        public int shortest(String word1, String word2) {
            int ans = Integer.MAX_VALUE;
            LinkedList<Integer> idx1 = indice.get(word1), idx2 = indice.get(word2);
            for (int i : idx1) {
                for (int j : idx2) {
                    ans = Math.min(ans, Math.abs(i-j));
                }
            }
            return ans;
        }

    }

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */

}
