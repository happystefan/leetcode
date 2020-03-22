package Y2020.facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q0244_Shortest_Word_Distance_II {

    class WordDistance {

        Map<String, List<Integer>> map = new HashMap<>();

        public WordDistance(String[] words) {
            for (int i = 0; i < words.length; i++) {
                map.computeIfAbsent(words[i], k -> new LinkedList<>()).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            int i = 0, j = 0;
            int rslt = Integer.MAX_VALUE;
            while (i < list1.size() && j < list2.size()) {
                rslt = Math.min(rslt, Math.abs(list1.get(i) - list2.get(j)));
                if (list1.get(i) < list2.get(j)) i++;
                else j++;
            }
            return rslt;
        }

    }

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */

}
