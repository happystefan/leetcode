package Y2020.facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q0792_Number_of_Matching_Subsequences {

    class solution1_TLE {

        public int numMatchingSubseq(String S, String[] words) {
            int rslt = 0;
            for (String word : words) {
                if (isSubSeq(word, S)) rslt++;
            }
            return rslt;
        }

        private boolean isSubSeq(String a, String b) {
            int i = 0;
            for (char c : b.toCharArray()) {
                if (c == a.charAt(i)) i++;
                if (i == a.length()) return true;
            }
            return false;
        }

    }

    class solution2 {

        public int numMatchingSubseq(String S, String[] words) {
            Map<Character, List<int[]>> wait = new HashMap<>();
            for (char c = 'a'; c <= 'z'; c++) {
                wait.computeIfAbsent(c, k -> new LinkedList<>());
            }
            for (int i = 0; i < words.length; i++) {
                wait.get(words[i].charAt(0)).add(new int[]{i, 0});
            }
            int rslt = 0;
            for (char c : S.toCharArray()) {
                List<int[]> meet = new LinkedList<>(wait.get(c));
                wait.get(c).clear();
                for (int[] pair : meet) {
                    String word = words[pair[0]];
                    int i = pair[1];
                    if (i == word.length() - 1) {
                        rslt++;
                        continue;
                    }
                    wait.get(word.charAt(i + 1)).add(new int[]{pair[0], i + 1});
                }
            }
            return rslt;
        }

    }

}
