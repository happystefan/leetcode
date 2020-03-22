package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0243_Shortest_Word_Distance {

    class solution_two_pass {

        public int shortestDistance(String[] words, String word1, String word2) {
            List<Integer> list1 = new LinkedList<>();
            List<Integer> list2 = new LinkedList<>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) list1.add(i);
                if (words[i].equals(word2)) list2.add(i);
            }
            int rslt = Integer.MAX_VALUE;
            int i = 0, j = 0;
            while (i < list1.size() && j < list2.size()) {
                rslt = Math.min(rslt, Math.abs(list1.get(i) - list2.get(j)));
                if (list1.get(i) < list2.get(j)) i++;
                else j++;
            }
            return rslt;
        }

    }

    class solution_one_pass {

        public int shortestDistance(String[] words, String word1, String word2) {
            int rslt = Integer.MAX_VALUE;
            int i = -1, j = -1;
            for (int k = 0; k < words.length; k++) {
                if (words[k].equals(word1)) i = k;
                if (words[k].equals(word2)) j = k;
                if (i == -1 || j == -1) continue;
                rslt = Math.min(rslt, Math.abs(i - j));
            }
            return rslt;
        }

    }


}
