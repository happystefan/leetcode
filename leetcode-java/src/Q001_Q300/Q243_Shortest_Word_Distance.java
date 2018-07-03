package Q001_Q300;

import java.util.ArrayList;

public class Q243_Shortest_Word_Distance {

    public int shortestDistance(String[] words, String word1, String word2) {
        ArrayList<Integer> idx1 = new ArrayList<>();
        ArrayList<Integer> idx2 = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) idx1.add(i);
            if (words[i].equals(word2)) idx2.add(i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i : idx1) {
            for (int j : idx2) {
                ans = Math.min(ans, Math.abs(i-j));
            }
        }
        return ans;
    }

}
