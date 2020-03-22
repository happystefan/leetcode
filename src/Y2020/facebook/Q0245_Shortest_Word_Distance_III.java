package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0245_Shortest_Word_Distance_III {

    class solution1_one_pass {

        public int shortestWordDistance(String[] words, String word1, String word2) {
            int i = -1, j = -1;
            int rslt = Integer.MAX_VALUE;
            for (int k = 0; k < words.length; k++) {
                if (words[k].equals(word1)) i = k;
                if (words[k].equals(word2)) {
                    if (word1.equals(word2)) i = j;
                    j = k;
                }
                if (i == -1 || j == -1) continue;
                rslt = Math.min(rslt, Math.abs(i - j));
            }
            return rslt;
        }

    }

    class solution1_two_pass {

        public int shortestWordDistance(String[] words, String word1, String word2) {
            List<Integer> list1 = new LinkedList<>();
            List<Integer> list2 = new LinkedList<>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) list1.add(i);
                if (words[i].equals(word2)) list2.add(i);
            }
            int rslt = Integer.MAX_VALUE;
            for (int i : list1) {
                for (int j : list2) {
                    if (word1.equals(word2) && i == j) continue;
                    rslt = Math.min(rslt, Math.abs(i - j));
                }
            }
            return rslt;
        }

    }

}
