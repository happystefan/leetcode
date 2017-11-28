package Q200_Q299;

import java.util.LinkedList;
import java.util.List;

public class Q245_Shortest_Word_Distance_III_B {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        List<Integer> idx1 = new LinkedList<>(), idx2 = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) idx1.add(i);
            if (words[i].equals(word2)) idx2.add(i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i : idx1) {
            for (int j : idx2) {
                if (word1.equals(word2) && i == j) continue;
                ans = Math.min(ans, Math.abs(i-j));
            }
        }
        return ans;
    }

}
